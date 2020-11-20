package HW1;
/**
 * Homework 8 -- PurdueStudent
 *
 * This program examines input and calculate yearly cost
 * based on specific parameters for Purdue students.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 11, 2020
 *
 *
 */

public class PurdueStudent extends CollegeStudent {
    private String major;

    public PurdueStudent(String firstName, String lastName, String id,
                         double gpa, String residency, boolean livesOffCampus, String major) {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        setMajor(major);
        switch (getMajor()) {
            case "Computer Science":
                setBookFees(200);
                super.setBookFees(200);
                break;
            case "Engineering":
                setBookFees(500);
                super.setBookFees(500);
                break;
            case "Liberal Arts":
                setBookFees(750);
                super.setBookFees(750);
                break;
            default:
                setBookFees(100);
                super.setBookFees(100);
                break;
        }

        if (getGpa() >= 3.75 && getGpa() <= 4.0) {
            setFinancialAid(5000);
            super.setFinancialAid(5000);
        } else if (getGpa() >= 3.5 && getGpa() < 3.75) {
            setFinancialAid(4500);
            super.setFinancialAid(4500);
        } else if (getGpa() >= 3.0 && getGpa() < 3.5) {
            setFinancialAid(3000);
            super.setFinancialAid(3000);
        } else if (getGpa() >= 2.5 && getGpa() < 3.0) {
            setFinancialAid(2500);
            super.setFinancialAid(2500);
        }
        if (Residency.valueOf(residency) == Residency.IN_STATE) {
            setTuition(9992);
            super.setTuition(9992);
        } else if (Residency.valueOf(residency) == Residency.OUT_OF_STATE) {
            setTuition(28794);
            super.setTuition(28794);
        } else if (Residency.valueOf(residency) == Residency.INTERNATIONAL) {
            setTuition(30954);
            super.setTuition(30954);
        }
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double calculateYearlyCost() {
        return getTuition() + getDormCost() * 12 + getBookFees() - getFinancialAid();
    }
}

