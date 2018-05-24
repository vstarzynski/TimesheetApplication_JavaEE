package ca.bcit.infosys.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import ca.bcit.infosys.employee.Employee;
import ca.bcit.infosys.timesheet.Timesheet;
import ca.bcit.infosys.timesheet.TimesheetCollection;


/**
 * Class that manages the Database of Timesheets.
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.0
 *
 */
@Named
@ApplicationScoped
public class TimesheetDB implements TimesheetCollection {

    /**
     * Serial version.
     */
    private static final long serialVersionUID = 1234L;
    
    /**
     * Minimum rows of a Timesheet.
     */
    private static final int MINIMUM_ROWS = 5;
       
    /**
     * Array List that works as a DataBase for the system.
     */
    private ArrayList<CustomTimesheet> timesheets = new ArrayList<CustomTimesheet>();

    /**
     * Constructor for the data base.
     * @param user user that has a timesheet
     */
    public TimesheetDB(Employee user) {
        if (timesheets.size() == 0) {
            System.out.println("Creating initial timesheet for this user...");
            CustomTimesheet ts = new CustomTimesheet();
            ts.setEmployee(user);
            ts.setOvertime(new BigDecimal(0));
            ts.setFlextime(new BigDecimal(0));
            //Add initial five empty rows for the timesheet
            for (int i = 0; i < MINIMUM_ROWS; i++) {
                ts.addRow();
            }
            timesheets.add(ts);
        }
    }
    
    /**
     * Return and List of Custom Timesheets.
     * @return timesheet
     */
    public List<CustomTimesheet> getCustomTimesheets() {
        return timesheets;
    }
    
    @Override
    public List<Timesheet> getTimesheets() {
     // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Timesheet> getTimesheets(Employee e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Timesheet getCurrentTimesheet(Employee e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String addTimesheet() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
