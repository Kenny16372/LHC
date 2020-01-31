package hr.dep;

import hr.Employee;
import hr.IROEmployee;

public class HRAssistant extends Employee {
    private IROEmployee employee;

    public HRAssistant(){
        super();
    }

    public IROEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(IROEmployee employee) {
        this.employee = employee;
    }

    public void removeEmployee(){
        this.employee = null;
    }
}
