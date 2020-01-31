package hr;

import infrastructure.lhc.Detector;
import infrastructure.lhc.IROExperiment;

public class Researcher extends Employee {
    private boolean isSenior;
    private ResearchGroup[] researchGroups;
    private IROExperiment experiment;

    public Researcher(){
        super();
        this.researchGroups = new ResearchGroup[3];
    }

    public void updateExperiment(Detector detector){
        this.experiment = detector.getCurrentExperiment();
        System.out.println(experiment.getUUID() + ":" + experiment.getIsHiggsBosonFound());
    }
}
