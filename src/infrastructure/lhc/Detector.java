package infrastructure.lhc;

import java.util.LinkedList;

import  infrastructure.security.Reader;

import com.google.common.eventbus.Subscribe;
import infrastructure.lhc.events.Analyse;
import lhc.Main;

import java.util.LinkedList;

public class Detector extends Subscriber{
    private String higgsBosonStructure;
    private boolean isActivated;
    private LinkedList<Experiment> experimentList = new LinkedList<>();
    private Reader reader;

    public Experiment getCurrentExperiment(){
        return this.experimentList.getLast();
    }
    public Detector(int id) {
        super(id);
        this.higgsBosonStructure = "higgs";
    }
    
    @Subscribe
    public void receive(Analyse event){
        Experiment experiment = event.experiment;
        boolean found = false;
        this.experimentList.add(experiment);
        for(Block b:experiment.getBlocks()){
            try{
                if(Main.search(b.getStructure(), this.higgsBosonStructure) > 0){
                    found = true;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        experiment.setIsHiggsBosonFound(found);
        System.out.println(experiment.getUUID() + ": " + experiment.getIsHiggsBosonFound());
    }
}
