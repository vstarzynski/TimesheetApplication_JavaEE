package ca.bcit.infosys.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ca.bcit.infosys.timesheet.Timesheet;

/**
 * A class representing a single Custom Timesheet.
 *
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.1
 */
public class CustomTimesheet extends Timesheet {

    /**
     * Serial Version.
     */
    private static final long serialVersionUID = 2131L;

    /** 
     * The ArrayList of all details (i.e. rows) that the form contains. 
     */
    private List<CustomTimesheetRow> customDetails;
    
    /**
     * Variable that represents the week number.
     */
    private int weekNumber;
    
    /**
     * Constructor for the class.
     */
    public CustomTimesheet() {
        super();
        customDetails = new ArrayList<CustomTimesheetRow>();
        System.out.println("Initializing custom timehseet...");
        weekNumber = super.getWeekNumber();
    }
    
    /**
     * Getter for the Week Number.
     * @return the week number
     */
    public int getWeekNumber2() {
        return weekNumber;
    }
    
    /**
     * Shift Week Number.
     * @param newWeekNumber Number of the new week
     * @param endWeek end date of the new week
     */
    public void shiftWeek(int newWeekNumber, Date endWeek) {
        this.weekNumber = newWeekNumber;
        super.setEndWeek(endWeek);
    }   
    
    /**
     * Add an empty row to to the timesheet.
     */
    @Override
    public void addRow() {
        System.out.println("Adding Custom Rows");
        customDetails.add(new CustomTimesheetRow());
    }
    
    /**
     * Getter for custom timesheet row details.
     * @return the details
     */
    public List<CustomTimesheetRow> getCustomDetails() {
        return customDetails;
    }
}
