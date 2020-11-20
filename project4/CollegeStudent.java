package project4;

/**
 * Project 4 -- CollegeStudent
 *
 * This program stores abstract fields and methods that will be
 * implemented.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 6, 2020
 *
 */

public abstract class CollegeStudent {
    protected double tuition;
    protected int age;
    protected String firstName;
    protected String lastName;
    protected String stateOfResidency;
    protected String major;
    protected String housing;
    protected String id;

    public abstract double getTuition();
    public abstract int getStudentAge();
    public abstract String getStudentFirstName();
    public abstract String getStudentLastName();
    public abstract String getStateOfResidence();
    public abstract String getFullName();
    public abstract void calculateTuition();
    public abstract String getMajor();
    public abstract String getHousing();
    public abstract String getState();
    public abstract String generateID();
    public abstract String getID();
}
