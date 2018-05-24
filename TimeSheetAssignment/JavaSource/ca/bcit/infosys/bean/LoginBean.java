package ca.bcit.infosys.bean;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ca.bcit.infosys.employee.Employee;
import java.util.List;


/**
 * Bean manager for the login page.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable { 
    
    /**
     * Serial Version.
     */
    private static final long serialVersionUID = 8923847239841L;
    
    /**
     * Represents the DB of users.
     */
    private EmployeeDB db = new EmployeeDB();
      
    /**
     * User informed in the login.
     */
    private String user;
    
    /**
     * Password informed in the login.
     */
    private String password;
    
    /**
     * Logged User of the session.
     */
    private LoggedUser lgUser = new LoggedUser();
      
    /**
     * Checks if the user exists.
     * @param args
     * @return xhtml to be accessed
     */
    public String checkUser() {
        List<Employee> userList = db.getEmployees();
        for (int i = 0; i < userList.size(); i++) {
            CustomEmployee tempEmp = (CustomEmployee) userList.get(i);
            if (user.equals(tempEmp.getUserName())) {
                if (tempEmp.getCredentials().getPassword().equals(password)) {
                    lgUser.setLoggedUser(tempEmp);
                    System.out.println("The logged name is: " + lgUser.getLoggedUser().getName());
                    return "timesheet";
                }    
            }
        }
        lgUser.setLoggedUser(null);
        return "login";
    }
    
    /**
     * Checks if the user is an administrator or not.
     * @param args
     * @return xhtml to be accessed
     */
    public String checkAdmin() {
        List<Employee> userList = db.getEmployees();
        for (int i = 0; i < userList.size(); i++) {
            CustomEmployee tempEmp = (CustomEmployee) userList.get(i);
            if (user.equals(tempEmp.getUserName()) && tempEmp.getAdmin()) {
                if (tempEmp.getCredentials().getPassword().equals(password)) {
                    lgUser.setLoggedUser(tempEmp);
                    return "admin";
                }    
            }
        }
        lgUser.setLoggedUser(null);
        return "index";
        
    }
    
    /**
     * Sets the user informed in the login.
     * @param inputUser the user name inputed.
     */
    public void setUser(String inputUser) {
        user = inputUser;
    }
    
    /**
     * Return the user inputed.
     * @return the user as a String.
     */
    public String getUser() {
        return user;
    }
    
    /**
     * Sets the password informed in the login.
     * @param inputPass the password name inputed.
     */
    public void setPassword(String inputPass) {
        password = inputPass;
    }
    
    /**
     * Return the password inputed.
     * @return the password as a String.
     */
    public String getPassword() {
        return password;
    }
}
