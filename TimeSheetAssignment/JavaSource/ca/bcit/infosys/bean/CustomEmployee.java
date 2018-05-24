package ca.bcit.infosys.bean;

import ca.bcit.infosys.employee.Credentials;
import ca.bcit.infosys.employee.Employee;

/**
 * Class that extends a customer to include the editable variable.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 *
 */
public class CustomEmployee extends Employee {

    /**
     * Serial version.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Boolean to edit users.
     */
    private boolean editable;
    
    /**
     * Variable that defines if a user is a admin or not.
     */
    private boolean admin;
    
    /**
     * Credentials of the user.
     */
    private Credentials credentials = new Credentials();
    
    /**
     * Timesheets that belong to this user.
     */
    private TimesheetDB tdDB;
    
    
    /**
     * Custom Employee constructor without parameters.
     */
    public CustomEmployee() {
        tdDB = new TimesheetDB(this);
    }
    
    /**
     * Custom Employee constructor with parameters.
     * @param empName the name of the employee.
     * @param number the empNumber of the user.
     * @param id the loginID of the user.
     */
    public CustomEmployee(final String empName, final int number, final String id) {
        super(empName, number, id);
    }
    
    /**
     * Custom Employee constructor with parameters.
     * @param empName the name of the employee.
     * @param number the empNumber of the user.
     * @param id the loginID of the user.
     * @param isAdmin if user is admin or not
     * @param pass password
     */
    public CustomEmployee(final String empName, 
                          final int number,
                          final String id,
                          boolean isAdmin,
                          String pass) {
        super(empName, number, id);
        admin = isAdmin;
        credentials.setUserName(id);
        credentials.setPassword(pass);
        tdDB = new TimesheetDB(this);
    }
    
    /**
     * Getter for the editable variable.
     * @return a boolean
     */
    public boolean getEditable() {
        return editable;
    }
    
    /**
     * Setter for the editable variable.
     * @param newValue new boolean
     */
    public void setEditable(boolean newValue) {
        editable = newValue;
    }    
    
    /**
     * Getter for the admin variable.
     * @return a boolean
     */
    public boolean getAdmin() {
        return admin;
    }
    
    /**
     * Setter for the admin variable.
     * @param newValue new boolean
     */
    public void setAdmin(boolean newValue) {
        admin = newValue;
    }
    
    /**
     * Getter for the credentials o the user.
     * @return credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }
    
    /**
     * Getter for the Timesheet DB.
     * @return timeSheetDb
     */
    public TimesheetDB getTimesheetDB() {
        return tdDB;
    }
}
