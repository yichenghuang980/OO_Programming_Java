package project1;
import java.util.Scanner; // import Scanner class

/**
 * Project 1 -- Wordiness
 *
 * This program uses Scanner to prompt the user for yes/no answer to a
 * series of questions. Based on these answers, it will determine the specific
 * type of tree the user describes.
 *
 * ct?r4Charas
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 3, 2020
 *
 */

public class Wordiness {
    static Scanner scan = new Scanner(System.in);

    static void textFiller() {
        System.out.println("Welcome to the Text Filler Game!");
        System.out.println("Please provide the following: ");

        System.out.println("Adjective: ");
        String adjective1 = scan.nextLine();
        System.out.println("Nationality: ");
        String nationality = scan.nextLine();
        System.out.println("Name: ");
        String name1 = scan.nextLine();
        System.out.println("Noun: ");
        String noun1 = scan.nextLine();
        System.out.println("Adjective: ");
        String adjective2 = scan.nextLine();
        System.out.println("Noun: ");
        String noun2 = scan.nextLine();
        System.out.println("Adjective: ");
        String adjective3 = scan.nextLine();
        System.out.println("Adjective: ");
        String adjective4 = scan.nextLine();
        System.out.println("Plural Noun: ");
        String plural = scan.nextLine();
        System.out.println("Noun: ");
        String noun3 = scan.nextLine();
        System.out.println("Number: ");
        String number1 = scan.nextLine();
        System.out.println("Shape: ");
        String shape = scan.nextLine();
        System.out.println("Food: ");
        String food1 = scan.nextLine();
        System.out.println("Food: ");
        String food2 = scan.nextLine();
        System.out.println("Number: plural");
        String number2 = scan.nextLine();
        System.out.printf("Pizza was invented by a %s %s chef named %s. %n", adjective1, nationality, name1);
        System.out.printf("To make a pizza, you need to take a lump of %s, and make a thin, round %s %s. %n",
                noun1, adjective2, noun2);
        System.out.printf("Then you cover it with %s sauce, %s cheese, and fresh chopped %s. %n",
                adjective3, adjective4, plural);
        System.out.printf("Next you have to bake it in a very hot %s. %n", noun3);
        System.out.printf("When it is done, cut it into %s %s. %n", number1, shape);
        System.out.printf("Some kids like %s pizza the best, but my favorite is the %s pizza. %n", food1, food2);
        System.out.printf("If I could, I would eat pizza %s times a day! %n", number2);
    }

    static void decryption() {
        System.out.println("Welcome to the Decryption Puzzle Solver!");
        System.out.println("Please enter a 10-character encrypted String: ");
        String secret = scan.nextLine();

        char lastChar = secret.charAt(secret.length() - 1);
        String s = Character.toString(lastChar);
        secret = secret.substring(0,4) + s + secret.substring(5,secret.length() - 1);
        secret = secret.replace('?','e');
        secret = secret.substring(5) + secret.substring(0,5);
        System.out.println("The unencrypted String is: " + secret);

    }

    static void citation() {
        System.out.println("Welcome to the Citation Manager!");

        System.out.println("Enter Author First Name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter Author Last Name: ");
        String lastName = scan.nextLine();
        System.out.println("Enter Book Title: ");
        String title = scan.nextLine();
        System.out.println("Enter Publisher: ");
        String publisher = scan.nextLine();
        System.out.println("Enter Publisher City: ");
        String city = scan.nextLine();
        System.out.println("Enter Publishing Year: ");
        String year = scan.nextLine();

        System.out.printf("MLA: %s, %s. %s. %s, %s. %n", lastName, firstName,
                title, publisher, year);
        System.out.printf("APA: %s, %s. (%s). %s. %s: %s. %n", lastName,
                firstName.substring(0,1), year, title, city, publisher);

    }

    static void subscription() {
        double sum = 0;
        System.out.println("Welcome to the Subscription Manager!");
        System.out.println("How long do you want to subscribe?");
        System.out.println("1. 1 Month");
        System.out.println("2. 3 Months");
        System.out.println("3. 6 Months");
        System.out.println("4. 12 Months");
        int duration = scan.nextInt();
        scan.nextLine();
        switch (duration) {
            case 1: sum += 9;
            break;
            case 2: sum += 18;
            break;
            case 3: sum += 30;
            break;
            case 4: sum += 50;
            break;
        }

        System.out.println("Do you have any institutional affiliations?");
        System.out.println("1. Purdue");
        System.out.println("2. Federal Government");
        System.out.println("3. AAA");
        System.out.println("4. Local Library");
        System.out.println("5. None");
        int prefer = scan.nextInt();
        scan.nextLine();

        System.out.println("Do you want to sign up for our live document editing service?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int edit = scan.nextInt();
        scan.nextLine();
        switch (edit) {
            case 1:
                switch (duration) {
                    case 1:
                        sum += 10;
                        break;
                    case 2:
                        sum += 3 * 10;
                        break;
                    case 3:
                        sum += 6 * 10;
                        break;
                    case 4:
                        sum += 12 * 10;
                        break;
                }
                break;
            case 2: sum += 0;
            break;
        }

        switch (prefer) {
            case 1: sum = sum * 0.7;
            break;
            case 2: sum = sum * 0.75;
            break;
            case 3: sum = sum * 0.9;
            break;
            case 4: sum = sum * 0.95;
            break;
            case 5: sum = sum * 1;
            break;
        }

        System.out.printf("Your total is: $%.2f %n", sum);

    }
    public static void main(String[] args) {
        System.out.println("Welcome to Wordiness!");
        System.out.println("What would you like to do?");
        System.out.println("1. Text Filler Game");
        System.out.println("2. Decryption Puzzle Solver");
        System.out.println("3. Citation Manager");
        System.out.println("4. Subscription Manager");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1: textFiller();
            break;
            case 2: decryption();
            break;
            case 3: citation();
            break;
            case 4: subscription();
            break;
        }

        System.out.println("Thank you for using Wordiness!");

    }
}
