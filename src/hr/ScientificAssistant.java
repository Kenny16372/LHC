package hr;

import hr.Employee;

import java.util.Date;

public class ScientificAssistant extends Employee {
    private Date periodFrom;
    private Date periodUntil;
    private ResearchGroup[] researchGroups;

    public ScientificAssistant(){
        super();
        this.researchGroups = new ResearchGroup[2];
    }
}
