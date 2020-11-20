package project3;

import java.util.ArrayList;

/**
 * Project 3 -- Employee
 *
 * This program stores information about employees and their actions.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 15, 2020
 *
 */

public class Employee {
    private int id;
    private String name;
    private String address;
    private double hourlyRate;
    private double hoursWorked;
    private ArrayList<String> actionList;

    public Employee(int id, String name, String address, double hourlyRate,
                    double hoursWorked, ArrayList<String> actionList) {
        setId(id);
        setName(name);
        setAddress(address);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
        setActionList(actionList);
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public double getHourlyRate() {
        return this.hourlyRate;
    }
    public double getHoursWorked() {
        return this.hoursWorked;
    }
    public ArrayList<String> getActionList() {
        return this.actionList;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public void setActionList(ArrayList<String> actionList) {
        this.actionList = actionList;
    }

    public void recordAction(int patronId, int bookId, int code) {
        actionList.add(patronId + "-" + bookId + "-" + code);
    }
}
