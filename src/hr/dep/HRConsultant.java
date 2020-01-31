package hr.dep;

import hr.Employee;
import hr.IEmployee;

public class HRConsultant extends Employee {
    private IEmployee employee;

    public HRConsultant(){
        super();
    }

    public IEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(IEmployee employee) {
        this.employee = employee;
    }

    public void removeEmployee(){
        this.employee = null;
    }
}
