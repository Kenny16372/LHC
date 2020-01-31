package hr;

public interface IEmployee extends IROEmployee{
    void setManager(boolean isManager);
    void setMentor(boolean isMentor);
    void setBudgetResponsibility(boolean hasBudgetResponsibility);
}
