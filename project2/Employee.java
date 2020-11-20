package project2;

/**
 * Project 2 -- Employee
 *
 * This program stores and find specific information about the employee
 * so that he/she can use it to calculate salary
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 27, 2020
 *
 */

public class Employee {
    private String name;
    private int yearsWorked;
    private int totalRentals;
    private double baseSalary;
    private int id;

    public Employee(String name, int yearsWorked,
                    int totalRentals, double baseSalary, int id) {
        this.name = name;
        this.yearsWorked = yearsWorked;
        this.totalRentals = totalRentals;
        this.baseSalary = baseSalary;
        this.id = id;
    }

    public Employee() { }

    public String getName() {
        return this.name;
    }

    public int getYearsWorked() {
        return this.yearsWorked;
    }

    public int getTotalRentals() {
        return this.totalRentals;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearsWorked(int year) {
        this.yearsWorked = year;
    }

    public void setTotalRentals(int rentals) {
        this.totalRentals = rentals;
    }

    public void setBaseSalary(double salary) {
        this.baseSalary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double calculateSalary() {
        return getBaseSalary() + getYearsWorked() * 0.5 * getTotalRentals();
    }
}
