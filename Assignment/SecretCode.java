package HW1;

import java.util.Scanner; // import Scanner class

/**
 * Homework 2 -- Secret Code
 *
 * This program uses Scanner to prompt a student for 4 secret messages.
 * It will modify them based on specific rules and print them together.
 *
 * Stackflow: how to remove space from string
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version January 29, 2020
 * Wxlrl $d0nx!
 * oytI'z aLaDwyoUwFiGurEDwzewO uT
 *          d wasasdfit?!asdfThatasdfwasn'tasdftooasdfhar
 *  akdfhaskdHave aoiera gooadfaod dayxfoy
 */

public class SecretCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // create a scanner object

        System.out.println("Enter the First Secret Message:");
        String first = scanner.nextLine();
        first = first.replace('x','e'); // replace x with e
        char fifthChar = first.charAt(5);
        first = first.replaceFirst("r",""); // remove first r
        first = first.replaceFirst("\\$",""); // remove first $
        first = first.replace('0','o'); // replace 0 with o
        first = first + fifthChar; // append fifth character

        System.out.println("Enter the Second Secret Message:");
        String second = scanner.nextLine();
        int spaceIndex = second.indexOf(" ");
        second = second.substring(0,spaceIndex) + second.substring(spaceIndex).toLowerCase(); // convert lowercase
        int lastSpace = second.lastIndexOf(" ");// remove the last space
        second = second.substring(0,lastSpace) + second.substring(lastSpace + 1);
        second = second.substring(3);// remove the first 3 characters
        second = second.replace('z','m');// replace z with m
        second = second.replace("w"," ");// replace w with space
        second = second.replaceFirst("a","g");// replace the first a with g

        System.out.println("Enter the Third Secret Message:");
        String third = scanner.nextLine();
        third = third.trim(); // trim leading whitespaces
        char secondChar = third.charAt(1);
        String s = Character.toString(secondChar);
        third = third.replace("asdf",s);// replace asdf with the second character
        third = third.substring(9) + third.substring(0,9);// put the first 8 characters in the end

        System.out.println("Enter the Fourth Secret Message:");
        String fourth = scanner.nextLine();
        fourth = fourth.substring(0,1) + fourth.substring(10,15) +
                fourth.substring(20,25) + fourth.substring(30,35) + "!";
        System.out.println("Final Message: " + first + second + third + fourth);  // Output final message
    }
}
