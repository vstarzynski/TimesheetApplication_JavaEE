package ca.bcit.infosys.bean;

/**
 * Class that represents the current logged user.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 *
 */
public class LoggedUser {

    /**
     * Cariavle that represents the logged user.
     */
    private static CustomEmployee loggedUser;
    
    /**
     * Sets the logged user of the section.
     * @param user the user
     */
    public void setLoggedUser(CustomEmployee user) {
        loggedUser = user;
    }
    
    /**
     * Gets the logged user of the session.
     * @return the user
     */
    public CustomEmployee getLoggedUser() {
        return loggedUser;
    }
    
}
