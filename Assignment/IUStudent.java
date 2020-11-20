package HW1;
/**
 * Homework 8 -- IUStudent
 *
 * This program examines input and calculate yearly cost
 * based on specific parameters for IU students.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 11, 2020
 *
 *
 */

public class IUStudent extends CollegeStudent {
    private double transportationCost;

    public IUStudent(String firstName, String lastName,
                     String id, double gpa, String residency, boolean livesOffCampus) {
        super(firstName, lastName, id, gpa, residency, livesOffCampus);
        setBookFees(1034);
        super.setBookFees(1034);
        if (livesOffCampus) {
            setTransportationCost(500);
        } else {
            setTransportationCost(100);
        }

        if (getGpa() >= 3.75 && getGpa() <= 4.0) {
            setFinancialAid(4500);
            super.setFinancialAid(4500);
        } else if (getGpa() >= 3.5 && getGpa() < 3.75) {
            setFinancialAid(3500);
            super.setFinancialAid(3500);
        } else if (getGpa() >= 3.0 && getGpa() < 3.5) {
            setFinancialAid(2750);
            super.setFinancialAid(2750);
        } else if (getGpa() >= 2.5 && getGpa() < 3.0) {
            setFinancialAid(2500);
            super.setFinancialAid(2500);
        }
        if (Residency.valueOf(residency) == Residency.IN_STATE) {
            setTuition(10534);
            super.setTuition(10534);
        } else if (Residency.valueOf(residency) == Residency.OUT_OF_STATE) {
            setTuition(34896);
            super.setTuition(34896);
        } else if (Residency.valueOf(residency) == Residency.INTERNATIONAL) {
            setTuition(38314);
            super.setTuition(38314);
        }
    }

    public double getTransportationCost() {
        return this.transportationCost;
    }

    public void setTransportationCost(double transportationCost) {
        this.transportationCost = transportationCost;
    }

    public double calculateYearlyCost() {
        return getTuition() + getDormCost() * 12 + getTransportationCost() +
                getBookFees() - getFinancialAid();
    }
}
