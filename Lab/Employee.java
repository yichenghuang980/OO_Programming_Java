package lab;

public abstract class Employee {
    private double yearlySalary;
    private boolean temporary;
    private boolean insured;

    public Employee() {
        setYearlySalary(45000.00);
        setTemporary(false);
        setInsured(false);
    }

    public Employee(double yearlySalary, boolean temporary, boolean insured) {
        setYearlySalary(yearlySalary);
        setTemporary(temporary);
        setInsured(insured);
    }

    public double getYearlySalary() {
        return this.yearlySalary;
    }
    public boolean isTemporary() {
        return this.temporary;
    }
    public boolean isInsured() {
        return this.insured;
    }
    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }
    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }
    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public abstract double calculateCompensation();

    public void printInfo() {
        System.out.printf("Base Salary: %.2f%n", getYearlySalary());
        System.out.printf("Temporary: %s%n", isTemporary());
        System.out.printf("Insured: %s%n", isInsured());
    }
}
