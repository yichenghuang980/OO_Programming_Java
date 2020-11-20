package project3;

/**
 * Project 3 -- Book
 *
 * This program stores information associated with each book in
 * the catalog.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 15, 2020
 *
 */

public class Book {
    private int id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String publisher;
    private String publisherCity;
    private int publicationYear;
    private int numCheckouts;
    private double purchasePrice;
    private boolean currentlyLoaned;

    public Book(int id, String title, String authorFirstName, String authorLastName,
                String publisher, String publisherCity, int publicationYear, int numCheckouts,
                double purchasePrice, boolean currentlyLoaned) {
        this.id = id;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.publisher = publisher;
        this.publisherCity = publisherCity;
        this.publicationYear = publicationYear;
        this.numCheckouts = numCheckouts;
        this.purchasePrice = purchasePrice;
        this.currentlyLoaned = currentlyLoaned;
    }
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthorFirstName() {
        return this.authorFirstName;
    }
    public String getAuthorLastName() {
        return this.authorLastName;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public String getPublisherCity() {
        return this.publisherCity;
    }
    public int getPublicationYear() {
        return this.publicationYear;
    }
    public int getNumCheckouts() {
        return this.numCheckouts;
    }
    public double getPurchasePrice() {
        return this.purchasePrice;
    }
    public boolean isCurrentlyLoaned() {
        return this.currentlyLoaned;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public void setNumCheckouts(int numCheckouts) {
        this.numCheckouts = numCheckouts;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setCurrentlyLoaned(boolean currentlyLoaned) {
        this.currentlyLoaned = currentlyLoaned;
    }
    public double averageLoanCost() {
        return getPurchasePrice() / getNumCheckouts();
    }
}
