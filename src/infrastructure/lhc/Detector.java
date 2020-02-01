package infrastructure.lhc;

import java.util.LinkedList;
import  infrastructure.security.Reader;

import com.google.common.eventbus.Subscribe;
import infrastructure.lhc.events.Analyse;
import java.util.LinkedList;
import  infrastructure.security.reader.Reader;

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
        
    }

    public void addExperiment(Experiment e){
        this.experimentList.add(e);
    }
}
