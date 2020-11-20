package project2;

/**
 * Project 2 -- Customer
 *
 * This program stores and find specific information about a customer
 * and calculate discount based on his/her information.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 27, 2020
 *
 */

public class Customer {
    private String name;
    private String address;
    private String zipCode;
    private int numRentals;

    public Customer(String name, String address, String zipCode, int numRentals) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.numRentals = numRentals;
    }

    public Customer() { }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public int getNumRentals() {
        return this.numRentals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setNumRentals(int numRentals) {
        this.numRentals = numRentals;
    }

    public double calculateDiscount() {
        double discount = getNumRentals() * 0.25 / 100;
        if (discount < 0.25) {
            return discount;
        } else {
            return 0.25;
        }
    }
}
