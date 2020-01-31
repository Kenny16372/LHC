package hr;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeManagement {
    instance;
    public Map<Integer, Employee> employeeMap;

    public Employee getEmployee(Integer id){
        return employeeMap.get(id);
    }

    public void addEmployee(Integer id, Employee employee){
        if(employeeMap == null){
            employeeMap = new HashMap<>();
        }
        employeeMap.put(id, employee);
    }

    public void removeEmployee(Integer id){
        employeeMap.remove(id);
    }
}
