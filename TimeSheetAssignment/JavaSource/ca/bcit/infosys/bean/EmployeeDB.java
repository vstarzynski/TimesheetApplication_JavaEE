package ca.bcit.infosys.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ca.bcit.infosys.employee.Credentials;
import ca.bcit.infosys.employee.Employee;
import ca.bcit.infosys.employee.EmployeeList;

/**
 * Class that manages the Database of Employees.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 *
 */
@Named
@ApplicationScoped
public class EmployeeDB implements EmployeeList {

    /**
     * Serial Version.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Array List that works as a DataBase for the system.
     */
    private static ArrayList<Employee> employeeDB = new ArrayList<Employee>();
    
    /**
     * Constructor for the data base.
     */
    public EmployeeDB() {
        if (employeeDB.size() == 0) {
            System.out.println("Creating the Master user...");
            employeeDB.add(new CustomEmployee("Master", 0, "admin", true, "pass"));
        }
    }
    
    @Override
    public List<Employee> getEmployees() {
        return employeeDB;
    }

    @Override
    public Employee getEmployee(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> getLoginCombos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee getCurrentEmployee() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee getAdministrator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean verifyUser(Credentials credential) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String logout(Employee employee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteEmployee(Employee userToDelete) {
        for (int i = 0; i < employeeDB.size(); i++) {
            if (employeeDB.get(i).getUserName().equals(userToDelete.getUserName())) {
                employeeDB.remove(i);
                break;
            }
        }
    }

    @Override
    public void addEmployee(Employee newEmployee) {
        
        CustomEmployee tempEmp = (CustomEmployee) newEmployee;
        
        if (validateUserName(tempEmp) && validateUserID(tempEmp)) {
            employeeDB.add(newEmployee);     
        }
        
    }
    
    /**
     * Validates a user name (should be unique).
     * @return a boolean
     * @param employee the employee to check
     */
    public boolean validateUserName(CustomEmployee employee) {
        
        String userName = employee.getCredentials().getUserName();

        for (int i = 0; i < employeeDB.size(); i++) {
            if (employeeDB.get(i).getUserName().equals(userName)) {
                System.out.println("Error: Duplicated userName");
                return false;
            }
        } 
        return true;
    }

    /**
     * Validates a user id (should be unique).
     * @return a boolean
     * @param employee the employee to check
     */
    public boolean validateUserID(CustomEmployee employee) {
        int userId = employee.getEmpNumber();

        for (int i = 0; i < employeeDB.size(); i++) {
            if (employeeDB.get(i).getEmpNumber() == userId) {
                System.out.println("Error: Duplicated ID");
                return false;
            }
        } 
        return true;
    }
}
