package HW1;

import java.util.Scanner; // import Scanner class

/**
 * Homework 1 -- Business Card
 *
 * This program uses Scanner to prompt a student for their name,
 * Birth Year, GPA, major, and email.
 * It will then output then line by line.
 *
 * Friday's lecture by head TA Jasper Weymouth
 * Intellij tutorial: creating your first java program
 * w3schools tutorial
 * Stackflow: Double decimal formatting
 * Post answered by Andrew Orlowski
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version January 21, 2020
 *
 */

public class BusinessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a scanner object

        System.out.println("Enter your Name");
        String name = scanner.nextLine();

        System.out.println("Enter your Year of Birth");
        int year = scanner.nextInt();
        scanner.nextLine();
        int age = 2020 - year;

        System.out.println("Enter your GPA");
        float gpa = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Enter your Major");
        String major = scanner.nextLine();

        System.out.println("Enter your Email");
        String email = scanner.nextLine();

        System.out.println("Name: " + name);  // Output user name
        System.out.println("Age: " + age);  // Output age
        System.out.println("GPA: " + String.format("%.2f", gpa));  // Output GPA
        System.out.println("Major: " + major);  // Output user major
        System.out.println("Email: " + email);  // Output email address
    }
}
