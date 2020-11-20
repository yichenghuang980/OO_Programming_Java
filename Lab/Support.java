package lab;

public class Support extends Employee{
    private double performanceBonus;

    public Support() {
        super();
        setPerformanceBonus(0);
    }

    public Support(double yearlySalary, boolean temporary, boolean insured, double performanceBonus) {
        setYearlySalary(yearlySalary);
        setTemporary(temporary);
        setInsured(insured);
        setPerformanceBonus(performanceBonus);
    }

    public double getPerformanceBonus() {
        return this.performanceBonus;
    }
    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
    }

    public double calculateCompensation() {
        return getYearlySalary() + getPerformanceBonus();
    }

    public void printInfo() {
        System.out.printf("Base Salary: %.2f%n", getYearlySalary());
        System.out.printf("Temporary: %s%n", isTemporary());
        System.out.printf("Insured: %s%n", isInsured());
        System.out.printf("Total Compensation: %.2f%n", calculateCompensation());
    }
}
