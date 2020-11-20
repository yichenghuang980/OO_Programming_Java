package project2;

/**
 * Project 2 -- Car
 *
 * This program stores and find specific information about the car that
 * the user wants to rent/buy and calculate corresponding prices.
 *
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 27, 2020
 *
 */

public class Car {

    private Classification type;
    private int maxSeating;
    private int towingCapacity;
    private double fuelEconomy;
    private String make;
    private String model;
    private String vin;
    private double purchasePrice;
    private int mileage;

    public Car(Classification type, int maxSeating, int towingCapacity, double fuelEconomy,
               String make, String model, String vin, double purchasePrice, int mileage) {
        this.type = type;
        this.maxSeating = maxSeating;
        this.towingCapacity = towingCapacity;
        this.fuelEconomy = fuelEconomy;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.purchasePrice = purchasePrice;
        this.mileage = mileage;

    }

    public Car() { }

    public Classification getType() {
        return this.type;
    }

    public int getMaxSeating() {
        return this.maxSeating;
    }

    public int getTowingCapacity() {
        return this.towingCapacity;
    }

    public double getFuelEconomy() {
        return this.fuelEconomy;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getVin() {
        return this.vin;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setType(Classification type) {
        this.type = type;
    }

    public void setMaxSeating(int maxSeating) {
        this.maxSeating = maxSeating;
    }

    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    public void setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double calculateRate(int numDays, boolean insurance) {
        int dailyRate = 20;
        if (getType() == Classification.ECONOMY || getType() == Classification.COMPACT) {
            dailyRate += 10;
        } else if (getType() == Classification.PREMIUM || getType() == Classification.SPORT) {
            dailyRate += 20;
        } else if (getType() == Classification.SUV || getType() == Classification.PICKUP) {
            dailyRate += 30;
        } else {
            dailyRate += 40;
        }

        if (insurance) {
            dailyRate += 15;
        }

        return dailyRate * numDays;
    }

    public double calculateSellPrice() {
        return getPurchasePrice() - getMileage() * 0.05;
    }
}
