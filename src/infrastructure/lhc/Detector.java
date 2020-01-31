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
    private LinkedList<Experiment> experimentList;
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
        this.experimentList.add(experiment);
        for(Block b:experiment.getBlocks()){
            if(Main.search(b.getStructure(), this.higgsBosonStructure) > 0){
                experiment.setIsHiggsBosonFound(true);
                return;
            }
        }
        experiment.setIsHiggsBosonFound(false);
    }
}
