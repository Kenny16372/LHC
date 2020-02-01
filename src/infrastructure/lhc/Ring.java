package infrastructure.lhc;

import com.google.common.eventbus.Subscribe;
import infrastructure.lhc.events.RunExperimentFull;
import infrastructure.lhc.events.RunExperimentPartial;
import infrastructure.security.ControlCenter;

import java.util.ArrayList;
import java.util.UUID;

public class Ring extends Subscriber{
    private int energy;
    private boolean isActivated;
    private Experiment currentExperiment;
    private Detector detector;
    private ProtonTrap[] protonTraps;
    private Magnet[] magnets;

    public Ring(int id){
        super(id);
        this.protonTraps = new ProtonTrap[2];
        this.magnets = new Magnet[72];
        for(int i=0; i < this.magnets.length; i++){
            this.magnets[i] = new Magnet();
        }
        for(int i=0; i < this.protonTraps.length; i++){
            this.protonTraps[i] = new ProtonTrap();
        }
    }
    
    public void activate(){}
    public void activate(int initialEnergy){}
    public void activateMagneticField(){
        for(Magnet magnet:this.magnets){
            magnet.activate();
        }
    }
    public void releaseProton(){
        for(ProtonTrap trap:this.protonTraps){
            trap.release();
        }
    }
    public void increaseEnergy(int delta){}
    public void collide(Proton proton01, Proton proton02 ){
        ArrayList<Block> blocks = new ArrayList<Block>();
        int[][][] structure1 = proton01.getStructure();
        int[][][] structure2 = proton02.getStructure();
        for(int x=0; x < 100; x++){
            for(int y=0; y < 100; y++){
                for(int z=0; z < 100; z+=5){
                    char[] block = new char[10];
                    for(int i=0; i<5; i++){
                        block[i] = (char) structure1[x][y][z+i];
                        block[i+5] = (char) structure2[x][y][z+i];
                    }
                    blocks.add(new Block(UUID.randomUUID(), String.copyValueOf(block)));
                }
            }
        }
        this.currentExperiment.setBlocks(blocks.toArray(new Block[blocks.size()]));
    }
    public int decreaseEnergy(){
        return energy;
    }
    public void shutdown(){}
    
    @Subscribe
    public void receive(RunExperimentFull event){
        this.currentExperiment = new Experiment();
        this.energy = event.initialEnergy;
        this.activateMagneticField();
        while(this.energy < 300000){
            this.energy = Math.min(this.energy + 25000, 300000);
        }
        this.releaseProton();
        this.collide(this.protonTraps[0].protons.pop(), this.protonTraps[1].protons.pop());
        this.detector.addExperiment(this.currentExperiment);
    }
    
    @Subscribe
    public void receive(RunExperimentPartial event){
        this.currentExperiment = new Experiment();
        this.energy = event.initialEnergy;
        this.activateMagneticField();
        while(this.energy < 300000){
            this.energy = Math.min(this.energy + 25000, 300000);
        }
        this.releaseProton();
        this.collide(this.protonTraps[0].protons.pop(), this.protonTraps[1].protons.pop());
        this.detector.addExperiment(this.currentExperiment);
    }
}
