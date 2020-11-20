package project3;

import java.util.ArrayList;

/**
 * Project 3 -- Patron
 *
 * This program stores information about patrons and their current loans.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 15, 2020
 *
 */

public class Patron {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private ArrayList<Integer> bookLoanList;

    public Patron(int id, String name, String address, String email,
                  String phoneNumber, ArrayList<Integer> bookLoanList) {
        setId(id);
        setName(name);
        setAddress(address);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setBookLoanList(bookLoanList);
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public ArrayList<Integer> getBookLoanList() {
        return this.bookLoanList;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setBookLoanList(ArrayList<Integer> bookLoanList) {
        this.bookLoanList = bookLoanList;
    }

    public void updateBookLoanList(int bookId) {
        int count = 0;
        for (int i = 0; i < bookLoanList.size(); i++) {
            if (bookLoanList.get(i) == bookId) {
                bookLoanList.remove(i);
                count += 1;
                break;
            }
        }
        if (count == 0) {
            bookLoanList.add(bookId);
        }
    }
}
