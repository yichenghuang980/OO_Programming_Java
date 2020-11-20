package HW1;
/**
 * Homework 8 -- CollegeStudent
 *
 * This program examines input and calculate yearly cost
 * based on specific parameters.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 11, 2020
 *
 *
 */

public class CollegeStudent {
    private String firstName;
    private String lastName;
    private String id;
    private double gpa;
    private Residency residency;
    private boolean livesOffCampus;
    private double dormCost;
    private double tuition;
    private double bookFees;
    private double financialAid;

    public CollegeStudent(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public CollegeStudent(String firstName, String lastName, String id,
                          double gpa, String residency, boolean livesOffCampus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gpa = gpa;
        this.residency = Residency.valueOf(residency);
        this.livesOffCampus = livesOffCampus;

        if (Residency.valueOf(residency) == Residency.IN_STATE) {
            setTuition(23000);
        } else if (Residency.valueOf(residency) == Residency.OUT_OF_STATE) {
            setTuition(42000);
        } else if (Residency.valueOf(residency) == Residency.INTERNATIONAL) {
            setTuition(44500);
        } else {
            throw new IllegalArgumentException(
                    "Student residency must be one of the three specified statuses");
        }

        if (gpa < 0) {
            throw new IllegalArgumentException("GPA needs to be above or equal to 0");
        }

        if (livesOffCampus) {
            setDormCost(500);
        } else {
            setDormCost(800);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getId() {
        return this.id;
    }

    public double getGpa() {
        return this.gpa;
    }

    public Residency getResidency() {
        return this.residency;
    }

    public boolean isLivingOffCampus() {
        return this.livesOffCampus;
    }

    public double getDormCost() {
        return this.dormCost;
    }

    public double getTuition() {
        return this.tuition;
    }

    public double getBookFees() {
        return this.bookFees;
    }

    public double getFinancialAid() {
        return this.financialAid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setResidency(String residency) {
        this.residency = Residency.valueOf(residency);
    }

    public void setLivesOffCampus(boolean livesOffCampus) {
        this.livesOffCampus = livesOffCampus;
    }

    public void setDormCost(double dormCost) {
        this.dormCost = dormCost;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void setBookFees(double bookFees) {
        this.bookFees = bookFees;
    }

    public void setFinancialAid(double financialAid) {
        this.financialAid = financialAid;
    }

    public double calculateYearlyCost() {
        return getTuition() + getDormCost() * 12 + getBookFees() - getFinancialAid();
    }
}
