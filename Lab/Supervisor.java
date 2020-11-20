package lab;

public class Supervisor extends Employee {
    private int teamSize;

    public Supervisor() {
        super();
        setTeamSize(0);
    }

    public Supervisor(double yearlySalary, boolean temporary, boolean insured, int teamSize) {
        setYearlySalary(yearlySalary);
        setTemporary(temporary);
        setInsured(insured);
        setTeamSize(teamSize);
    }

    public int getTeamSize() {
        return this.teamSize;
    }
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public double calculateCompensation() {
        return getYearlySalary() + getTeamSize() * 2000;
    }

    public void printInfo() {
        System.out.printf("Base Salary: %.2f%n", getYearlySalary());
        System.out.printf("Temporary: %s%n", isTemporary());
        System.out.printf("Insured: %s%n", isInsured());
        System.out.printf("Team Size: %s%n", getTeamSize());
        System.out.printf("Total Compensation: %.2f%n", calculateCompensation());
    }
}
