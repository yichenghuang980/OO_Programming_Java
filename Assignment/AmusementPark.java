package HW1;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Homework 12 -- AmusementPark
 *
 * This program extends CollegeStudent and implements its methods
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 15, 2020
 *
 */

public class AmusementPark {

    public static void main(String[] args) {
        // step 1: Welcome
        JOptionPane.showMessageDialog(null, "Welcome to Amusement Park!", "Welcome",
                JOptionPane.INFORMATION_MESSAGE);

        // step 2: Choose Park
        String[] placeList = {"Walt Disney World", "Universal Studios", "Beto Carrero World", "Cedar Point"};
        UIManager.put("OptionPane.okButtonText", "Continue");
        String place = (String) JOptionPane.showInputDialog(null, "What is your choice?",
                "Choose Amusement Park", JOptionPane.QUESTION_MESSAGE, null, placeList, placeList[0]);
        if (place == null) {
            return;
        }

        //step 3: Main Menu
        ArrayList<ArrayList<String>> selection = new ArrayList<>();
        ArrayList<Double> priceList = new ArrayList<>();
        double price = 1.00;
        String message = "";

        while (true) {
            double total = 0.00;
            ArrayList<String> information = new ArrayList<>();

            String[] actionList = {"Add New Ticket", "Check Order", "Checkout"};
            int action = JOptionPane.showOptionDialog(null, "Choose Your Action", "Action",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, actionList, actionList[0]);

            switch (action) {
                // step 4: Ticket Type
                case 0:
                    String[] parkList = {"Single-Park", "Multi-Park"};
                    String park = (String) JOptionPane.showInputDialog(null,
                            "What is your ticket type?", "Ticket Type", JOptionPane.QUESTION_MESSAGE,
                            null, parkList, parkList[0]);
                    if (park == null) {
                        continue;
                    }

                    // step 5: Ticket Class
                    String[] ageList = {"Adult", "Child", "Student", "Senior"};
                    String age = (String) JOptionPane.showInputDialog(null,
                            "What is your ticket class?", "Ticket Class", JOptionPane.QUESTION_MESSAGE,
                            null, ageList, ageList[0]);

                    if (age != null) {
                        information.add(place);
                        information.add(park);
                        information.add(age);
                        selection.add(information);
                    }
                    break;

                // step 6: Check Order
                case 1:
                    if (selection.size() == 0) {
                        UIManager.put("OptionPane.okButtonText", "Continue");
                        JOptionPane.showMessageDialog(null, "No tickets!", "Check Order",
                                JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    message = "";
                    priceList = new ArrayList<>();
                    for (ArrayList<String> element : selection) {
                        switch (element.get(1)) {
                            case "Single-Park":
                                price = 1.00;
                                break;

                            case "Multi-Park":
                                price = 1.30;
                                break;
                        }
                        switch (element.get(0)) {
                            case "Walt Disney World":
                                switch (element.get(2)) {
                                    case "Child":
                                        price *= 60;
                                        break;
                                    case "Adult":
                                        price *= 130;
                                        break;
                                    default:
                                        price *= 95;
                                        break;
                                }
                                break;

                            case "Universal Studios":
                                switch (element.get(2)) {
                                    case "Child":
                                        price *= 35;
                                        break;
                                    case "Senior":
                                        price *= 80;
                                        break;
                                    default:
                                        price *= 110;
                                        break;
                                }
                                break;

                            case "Beto Carrero World":
                                switch (element.get(2)) {
                                    case "Student":
                                        price *= 100;
                                        break;
                                    case "Adult":
                                        price *= 115;
                                        break;
                                    default:
                                        price *= 70;
                                        break;
                                }
                                break;

                            case "Cedar Point":
                                switch (element.get(2)) {
                                    case "Child":
                                        price *= 20;
                                        break;
                                    case "Student":
                                        price *= 40;
                                        break;
                                    case "Adult":
                                        price *= 60;
                                        break;
                                    case "Senior":
                                        price *= 30;
                                        break;
                                }
                                break;
                        }
                        priceList.add(price);
                        message += String.format("Park: %s\nType: %s\nClass: %s\nPrice: %.2f\n", element.get(0),
                                element.get(1), element.get(2), price);

                    }
                    JOptionPane.showMessageDialog(null, message,
                            "Check Order", JOptionPane.INFORMATION_MESSAGE);
                    continue;

                // step 7: Check Out
                case 2:
                    // step 8: Warning
                    if (selection.size() == 0) {
                        String[] warnList = {"Continue Adding Order", "Quit"};
                        int warn = JOptionPane.showOptionDialog(null, "No Ticket Was Added!",
                                "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, warnList, warnList[0]);
                        switch (warn) {
                            case 0:
                                continue;
                            case 1:
                                return;
                        }
                    }

                    // normal checkout
                    message = "";
                    priceList = new ArrayList<>();
                    for (ArrayList<String> element : selection) {
                        switch (element.get(1)) {
                            case "Single-Park":
                                price = 1.00;
                                break;

                            case "Multi-Park":
                                price = 1.30;
                                break;
                        }
                        switch (element.get(0)) {
                            case "Walt Disney World":
                                switch (element.get(2)) {
                                    case "Child":
                                        price *= 60;
                                        break;
                                    case "Adult":
                                        price *= 130;
                                        break;
                                    default:
                                        price *= 95;
                                        break;
                                }
                                break;

                            case "Universal Studios":
                                switch (element.get(2)) {
                                    case "Child":
                                        price *= 35;
                                        break;
                                    case "Senior":
                                        price *= 80;
                                        break;
                                    default:
                                        price *= 110;
                                        break;
                                }
                                break;

                            case "Beto Carrero World":
                                switch (element.get(2)) {
                                    case "Student":
                                        price *= 100;
                                        break;
                                    case "Adult":
                                        price *= 115;
                                        break;
                                    default:
                                        price *= 70;
                                        break;
                                }
                                break;

                            case "Cedar Point":
                                switch (element.get(2)) {
                                    case "Child":
                                        price *= 20;
                                        break;
                                    case "Student":
                                        price *= 40;
                                        break;
                                    case "Adult":
                                        price *= 60;
                                        break;
                                    case "Senior":
                                        price *= 30;
                                        break;
                                }
                                break;
                        }
                        priceList.add(price);
                        message += String.format("Park: %s\nType: %s\nClass: %s\nPrice: %.2f\n", element.get(0),
                                element.get(1), element.get(2), price);

                    }
                    total = 0.00;
                    for (Double payment : priceList) {
                        total += payment;
                    }
                    total *= 1.7;
                    String[] optionList = {"Confirm", "Cancel"};
                    int option = JOptionPane.showOptionDialog(null,
                            String.format("Your payment amount is: %.2f", total),
                            "Check Out", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, optionList, optionList[0]);

                    // step 9: Order Complete
                    if (option == 0) {
                        String[] finalList = {"Exit"};
                        int exit = JOptionPane.showOptionDialog(null,
                                "Your Order Is Complete!", "Order Complete!",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, finalList, finalList[0]);
                        return;
                    }
                    break;
            }
        }
    }
}
