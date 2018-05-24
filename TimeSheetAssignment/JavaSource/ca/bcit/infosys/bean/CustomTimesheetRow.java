package ca.bcit.infosys.bean;

import java.math.BigDecimal;

import ca.bcit.infosys.timesheet.TimesheetRow;

/**
 * A class representing a single Custom TimesheetRow.
 *
 * @author Victor Starzynski and Raymond Gollinger
 * @version 1.1
 */
public class CustomTimesheetRow extends TimesheetRow {

    /**
     * Serial Number.
     */
    private static final long serialVersionUID = 1235L;
    
    /**
     * Hours per day.
     */
    private static final int HOURS_PER_DAY = 24;

    /**
     * Total hours of the week.
     */
    private double totalHours;

    /**
     * Hours of Saturday.
     */
    private double saturdayHours;
    
    /**
     * Hours of Sunday.
     */
    private double sundayHours;
    
    /**
     * Hours of Monday.
     */
    private double mondayHours;
    
    /**
     * Hours of Tuesday.
     */
    private double tuesdayHours;
    
    /**
     * Hours of Wednesday.
     */
    private double wednesdayHours;
    
    /**
     * Hours of Thursday.
     */
    private double thursdayHours;
    
    /**
     * Hours of Friday.
     */
    private double fridayHours;
    
    
    /**
     * Constructor of the Custom Row.
     */
    public CustomTimesheetRow() {
        super();
    }
    
    /**
     * Getter for the total hours.
     * @return total hours
     */
    public double getTotalHours() {
        totalHours = 0;
        BigDecimal[] totHours = super.getHoursForWeek();
        for (int i = 0; i <= FRI; i++) {
            if (totHours[i] != null) {
                totalHours += totHours[i].doubleValue();
            }
        }  
        return totalHours;
    }
    
    /**
     * Update total hours.
     * @param value double
     */
    public void setTotalHours(double value) {
        totalHours = value;
    }
    
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setSaturdayHours(double value) {
        
        if (validateChange(value)) {
            super.setHour(SAT, value);
            saturdayHours = super.getHour(SAT).doubleValue();
        }  
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getSaturdayHours() {
        return saturdayHours;
    }
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setSundayHours(double value) {       
        if (validateChange(value)) {
            super.setHour(SUN, value);
            sundayHours = super.getHour(SUN).doubleValue();
        }
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getSundayHours() {
        return sundayHours;
    }
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setMondayHours(double value) {
        if (validateChange(value)) {
            super.setHour(MON, value);
            mondayHours = super.getHour(MON).doubleValue();
        }
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getMondayHours() {
        return mondayHours;
    }
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setTuesdayHours(double value) {
        if (validateChange(value)) {
            super.setHour(TUE, value);
            tuesdayHours = super.getHour(TUE).doubleValue();
        }
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getTuesdayHours() {
        return tuesdayHours;
    }
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setWednesdayHours(double value) {       
        if (validateChange(value)) {
            super.setHour(WED, value);
            wednesdayHours = super.getHour(WED).doubleValue();
        }
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getWednesdayHours() {
        return wednesdayHours;
    }
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setThursdayHours(double value) {
        if (validateChange(value)) {
            super.setHour(THU, value);
            thursdayHours = super.getHour(THU).doubleValue();
        }
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getThursdayHours() {
        return thursdayHours;
    }
    
    /**
     * Setter for day hour.
     * @param value double
     */
    public void setFridayHours(double value) {       
        if (validateChange(value)) {
            super.setHour(FRI, value);
            fridayHours = super.getHour(FRI).doubleValue();
        }
    }
    
    /**
     * Getter for the hours of the day.
     * @return double
     */
    public double getFridayHours() {
        return fridayHours;
    }
    
    /**
     * Validates input.
     * @param newValue value to validate
     * @return validation
     */
    private boolean validateChange(double newValue) {
        
        if (newValue > 0 && newValue < HOURS_PER_DAY) {
            return true;
        }
        
        return false;
    }
    
}
