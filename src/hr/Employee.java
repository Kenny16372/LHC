package hr;


abstract public class Employee extends Person implements IEmployee{
    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;

    public Employee(){
        super();
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isMentor() {
        return isMentor;
    }

    public void setMentor(boolean mentor) {
        isMentor = mentor;
    }

    public boolean hasBudgetResponsibility() {
        return hasBudgetResponsibility;
    }

    public void setBudgetResponsibility(boolean hasBudgetResponsibility) {
        this.hasBudgetResponsibility = hasBudgetResponsibility;
    }
}
