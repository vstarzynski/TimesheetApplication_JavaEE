package ca.bcit.infosys.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import ca.bcit.infosys.timesheet.Timesheet;

/**
 * Bean manager for the timesheet page.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0 
 */
@Named("timesheetBean")
@SessionScoped
public class TimesheetBean implements Serializable {

    /**
     * Minimum rows of a Timesheet.
     */
    private static final int MINIMUM_ROWS = 5;
    
    /**
     * Week Size.
     */
    private static final int WEEK_SIZE = 7;
    
    /**
     * Serial version.
     */
    private static final long serialVersionUID = 28431L;
        
    /**
     * Logged User of the session.
     */
    private LoggedUser lgUser = new LoggedUser();
    
    /**
     * Array of existing timesheets.
     */
    private List<CustomTimesheet> userTimesheets;
    
    /**
     * Selected Timesheet.
     */
    private CustomTimesheet selectedTimesheet; 
    
    /**
     * Getter for the user timesheets.
     * @return a List with timesheets.
     */
    public List<CustomTimesheet> getUserTimesheets() { 
        userTimesheets = lgUser.getLoggedUser().getTimesheetDB().getCustomTimesheets();
        return userTimesheets;
    }
    
    /**
     * Add empty timesheet in the list.
     * @return next page
     */
    public String addTimesheet() {
        int i;
        int lastWeekNumber = userTimesheets.get(userTimesheets.size() - 1).getWeekNumber2();
        Date lastWeekEndDate = userTimesheets.get(userTimesheets.size() - 1).getEndWeek();
        Date newDate = null;
        
        CustomTimesheet ts = new CustomTimesheet();        
        ts.setEmployee(lgUser.getLoggedUser());
        ts.setOvertime(new BigDecimal(0));
        ts.setFlextime(new BigDecimal(0));
        
        Calendar c = Calendar.getInstance();
        c.setTime(lastWeekEndDate);
        c.add(Calendar.DATE, WEEK_SIZE);
        newDate = c.getTime();
        
        ts.shiftWeek(lastWeekNumber + 1, newDate);
        //Add initial five empty rows for the timesheet
        for (i = 0; i < MINIMUM_ROWS; i++) {
            ts.addRow();
        }
        lgUser.getLoggedUser().getTimesheetDB().getCustomTimesheets().add(ts);        
        return "timesheet";
    }
    
    /**
     * Add row to Timesheet.
     * @return new row
     */
    public String addRow() {
        selectedTimesheet.addRow();
        return "timesheetdetail";
    }
    
    /**
     * Return the logged user of the session.
     * @return Logged User
     */
    public LoggedUser getlgUser() {
        return lgUser;
    }
    
    /**
     * Open selected timesheet.
     * @return the next page
     */
    public String openTimesheet() {      
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        String weekStr = (String) map.get("id");
        int selectedWeek = Integer.parseInt(weekStr);
        
        System.out.println("Recovered value: " + selectedWeek);
        
        for (int i = 0; i < userTimesheets.size(); i++) {
            if (userTimesheets.get(i).getWeekNumber() == selectedWeek) {
                selectedTimesheet =  userTimesheets.get(i);
            }
        }                
        return "timesheetdetail";
    }
    
    /**
     * Getter for the selected timesheet.
     * @return a timesheet
     */
    public Timesheet getSelectedTimesheet() {
        return selectedTimesheet;
    }    
}
