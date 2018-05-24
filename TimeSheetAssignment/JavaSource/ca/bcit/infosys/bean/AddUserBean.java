package ca.bcit.infosys.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Bean that manages the add user page.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 *
 */
@Named("addUserBean")
@SessionScoped
public class AddUserBean implements Serializable {

    /**
     * Serial Version.
     */
    private static final long serialVersionUID = 14574L;

    /**
     * Represents the DB of users.
     */
    private EmployeeDB db = new EmployeeDB();
    
    /**
     * Variable for the name of the new user.
     */
    private String newName;
    
    /**
     * Variable for the id of the new user.
     */
    private int id;
    
    /**
     * Variable for the user name of the new user.
     */
    private String newUserName;
    
    /**
     * Variable for the password of the new user.
     */  
    private String password;
    
    /**
     * Variable to check the password of the new user.
     */
    private String checkPass;
    
    /**
     * Variable to define if the new user is a Admin.
     */   
    private boolean admin;
    
   /**
    * Add user to database.
    * @return the next page
    */
    public String addUser() {
        
        System.out.println("Pass: " + password);
        System.out.println("Check Pass: " + checkPass);
        
        if (password.equals(checkPass)) {
            System.out.println("Adding user");
            CustomEmployee newEmployee = new CustomEmployee(newName, id, newUserName, admin, password);
            db.addEmployee(newEmployee);
            clearFields();
            return "admin";
        }
        return "adduser";
    }
    
    /**
     * Clear the fields.
     */
    public void clearFields() {
        newName = "";
        id = 0;
        newUserName = "";
        password = "";
        checkPass = "";
        admin = false;
    }
    
    /**
     * Setter for the new name.
     * @param newName name
     */
    public void setNewName(String newName) {
        this.newName = newName;
    }
    
    /**
     * Getter for the new name.
     * @return name as string
     */
    public String getNewName() {
        return this.newName;
    }
    
    /**
     * Setter for the new id.
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter for the new id.
     * @return id as int
     */
    public int getId() {
        return id;
    }
    
    /**
     * Setter for the new name.
     * @param newUser user name
     */
    public void setNewUserName(String newUser) {
        this.newUserName = newUser;
    }
    
    /**
     * Getter for the new name.
     * @return name as string
     */
    public String getNewUserName() {
        return this.newUserName;
    }
    
    /**
     * Setter for the new password.
     * @param newPass user password
     */
    public void setPassword(String newPass) {
        this.password = newPass;
    }
    
    /**
     * Getter for the new password.
     * @return name as string
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Setter for the new check password.
     * @param newPass user password
     */
    public void setCheckPass(String newPass) {
        this.checkPass = newPass;
    }
    
    /**
     * Getter for the new check password.
     * @return name as string
     */
    public String getCheckPass() {
        return this.checkPass;
    }
    
    /**
     * Setter for the new admin oolean.
     * @param newValue user admin status
     */
    public void setAdmin(boolean newValue) {
        this.admin = newValue;
    }
    
    /**
     * Getter for the new admin boolean.
     * @return user admin status
     */
    public boolean getAdmin() {
        return this.admin;
    }
}
