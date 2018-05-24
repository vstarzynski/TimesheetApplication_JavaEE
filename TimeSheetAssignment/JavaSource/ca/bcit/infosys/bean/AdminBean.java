package ca.bcit.infosys.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ca.bcit.infosys.employee.Employee;

/**
 * Bean that managers the administrator page.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 *
 */
@Named("adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    /**
     * Serial version.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Represents the DB of users.
     */
    private EmployeeDB db = new EmployeeDB();
    
    /**
     * Array of existing users.
     */
    private List<Employee> userList;

    /**
     * Getter for the user List.
     * @return a List with users.
     */
    public List<Employee> getUserList() {
        userList = db.getEmployees();
        return userList;
    }
    
    /**
     * Add user in the list.
     * @return the next page
     */
    public String addUser() {
        return "adduser";
    }
    
    /**
     * Removes user from list.
     * @return the admin page
     */
    public String removeUser() {
        for (int i = 0; i < userList.size(); i++) {
            CustomEmployee temp = (CustomEmployee) userList.get(i);
            if (temp.getEditable()) {
                db.deleteEmployee(temp);
                System.out.println("user deleted!");
                break;
            }
        }
        return "admin";
    }
    
    /**
     * Save modifications made on the users.
     */
    public void save() {     
        for (int i = 0; i < userList.size(); i++) {
            //Update Database
            CustomEmployee tempEmployee = (CustomEmployee) userList.get(i);
            tempEmployee.setEditable(false);            
        }
     }
}
