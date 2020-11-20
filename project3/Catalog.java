package project3;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Project 3 -- Catalog
 *
 * This program stores the entire library's catalog of books.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 15, 2020
 *
 */

public class Catalog {
    private ArrayList<Book> catalog = new ArrayList<>();
    public Catalog() { }
    boolean loan;

    public void loadCatalog(File bookCatalog) throws IOException, UnsupportedFileException {
        FileReader fr = new FileReader(bookCatalog);
        BufferedReader bfr = new BufferedReader(fr);

        while (true) {
            String[] detailList;
            String line = bfr.readLine();
            if (line == null) {
                break;
            }
            detailList = line.split(",");
            if (detailList.length < 10) {
                throw new UnsupportedFileException("Missing fields in the file!");
            }
            switch (detailList[9].trim()) {
                case "Yes":
                    loan = true;
                    break;
                case "No":
                    loan = false;
                    break;
            }
            Book newEntry = new Book(Integer.parseInt(detailList[0].trim()), detailList[1].trim(), detailList[2].trim(),
                    detailList[3].trim(), detailList[4].trim(), detailList[5].trim(),
                    Integer.parseInt(detailList[6].trim()), Integer.parseInt(detailList[7].trim()),
                    Double.parseDouble(detailList[8].trim()), loan);
            addBook(newEntry);
        }
        bfr.close();
    }

    public void writeCatalog(File bookCatalog) throws IOException {
        FileOutputStream fos = new FileOutputStream(bookCatalog);
        PrintWriter pw = new PrintWriter(fos);
        for (Book element : catalog) {
            String newContent = "";
            switch (Boolean.toString(element.isCurrentlyLoaned())) {
                case "true":
                    String price = String.format("%.2f", element.getPurchasePrice());
                    newContent = element.getId() + ", " + element.getTitle() + ", " + element.getAuthorFirstName() +
                            ", " + element.getAuthorLastName() + ", " + element.getPublisher() + ", " +
                            element.getPublisherCity() + ", " + element.getPublicationYear() + ", " +
                            element.getNumCheckouts() + ", " + price + ", Yes";
                    break;
                case "false":
                    price = String.format("%.2f", element.getPurchasePrice());
                    newContent = element.getId() + ", " + element.getTitle() + ", " + element.getAuthorFirstName() +
                            ", " + element.getAuthorLastName() + ", " + element.getPublisher() + ", " +
                            element.getPublisherCity() + ", " + element.getPublicationYear() + ", " +
                            element.getNumCheckouts() + ", " + price + ", No";
                    break;
            }
            pw.println(newContent);
        }
        pw.close();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public boolean removeBook(int id) {
        int count = 0;
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getId() == id) {
                catalog.remove(i);
                count += 1;
                return true;
            }
        }
        return false;
    }

    public boolean loanBook(int id) {
        for (Book element : catalog) {
            if (element.getId() == id && !element.isCurrentlyLoaned()) {
                element.setCurrentlyLoaned(true);
                element.setNumCheckouts(element.getNumCheckouts() + 1);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> findBooks(String search) {
        ArrayList<Book> newList = new ArrayList<>();
        search = search.toLowerCase();
        for (Book element : catalog) {
            if (element.getTitle().toLowerCase().contains(search) ||
                   element.getAuthorFirstName().toLowerCase().contains(search) ||
                   element.getAuthorLastName().toLowerCase().contains(search) ||
                   element.getPublisher().toLowerCase().contains(search) ||
                   element.getPublisherCity().toLowerCase().contains(search)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public ArrayList<Book> bookSale() {
        ArrayList<Book> newList = new ArrayList<>();
        for (Book element : catalog) {
            if (element.getNumCheckouts() < 10 && !element.isCurrentlyLoaned()) {
                newList.add(element);
            }
        }
        return newList;
    }

    public double avgCostPerLoan() {
        double totalCost = 0;
        for (Book element : catalog) {
            totalCost += element.averageLoanCost();
        }
        return totalCost / catalog.size();
    }

    public void printCatalogToFile(int mode, File newFile) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(newFile);
        PrintWriter pw = new PrintWriter(fos);
        String newContent;
        switch (mode) {
            case 1:
                for (Book element : catalog) {
                    newContent = "MLA: " + element.getAuthorLastName() + ", " + element.getAuthorFirstName()
                            + ". " + element.getTitle() + ". " + element.getPublisher() + ", " +
                            element.getPublicationYear() + ".";
                    pw.println(newContent);
                }
                break;
            case 2:
                for (Book element : catalog) {
                    newContent = "APA: " + element.getAuthorLastName() + ", " +
                            element.getAuthorFirstName().substring(0, 1) + ". (" + element.getPublicationYear() + "). "
                            + element.getTitle() + ". " + element.getPublisherCity() + ": " +
                            element.getPublisher() + ".";
                    pw.println(newContent);
                }
                break;
            case 3:
                for (Book element : catalog) {
                    if (element.isCurrentlyLoaned()) {
                        newContent = "CS: " + element.getAuthorLastName() + ", " + element.getAuthorFirstName() + ". " +
                                element.getTitle() + ". Number of Checkouts: " + element.getNumCheckouts() + ". " +
                                "Currently Checked Out: Yes.";
                        pw.println(newContent);
                    } else if (!element.isCurrentlyLoaned()) {
                        newContent = "CS: " + element.getAuthorLastName() + ", " + element.getAuthorFirstName() + ". " +
                                element.getTitle() + ". Number of Checkouts: " + element.getNumCheckouts() + ". " +
                                "Currently Checked Out: No.";
                        pw.println(newContent);
                    }
                }
                break;
        }
        pw.close();
    }

    public int numBooksLoaned() {
        int count = 0;
        for (Book element : catalog) {
            if (element.isCurrentlyLoaned()) {
                count += 1;
            }
        }
        return count;
    }

    public ArrayList<Book> getCatalog() {
        return this.catalog;
    }
    public void setCatalog(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }
}
