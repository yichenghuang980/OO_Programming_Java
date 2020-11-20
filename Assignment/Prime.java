package HW1;
import java.util.ArrayList; // import ArrayList class
import java.util.Scanner; // import Scanner class
import java.util.List; // import List class

/**
 * Homework 4 -- Prime
 *
 * This program uses Scanner to prompt the user for an integer value.
 * It will then validate the input and perform calculations to find
 * the greatest prime number
 *
 * Stackflow: how to find prime number
 * java list: how to initialize an array list
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 11, 2020
 *
 */

public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double pow = Math.pow(10, 9);
        System.out.println("Enter number N: ");
        int number = scan.nextInt();
        scan.nextLine();

        if (number < 0) {
            System.out.println("Terminating program...");
            System.out.println("Bye!");
            return;
        }

        while (number < 2 | number > pow) { // check input validity

            if (number < 0 ) {
                System.out.println("Terminating program...");
                System.out.println("Bye!");
                return;
            }

            if (number < 2) {
                System.out.println("N should not be less than 2");
                System.out.println("Enter number N: ");
                number = scan.nextInt();
                scan.nextLine();
            } else if (number > pow) {
                System.out.println("N should not be bigger than 1e9");
                System.out.println("Enter number N: ");
                number = scan.nextInt();
                scan.nextLine();
            }

        } // end while loop

        while (number >= 2 && number <= pow) { // perform calculations
            int sum = 0;
            int i = 2;
            List<Integer> primeList = new ArrayList<>();
            boolean isPrime = true;

            while (i <= number) {

                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primeList.add(i);
                    sum += i;
                    if (sum > number) {
                        String s = String.valueOf(primeList.get(primeList.size() - 2));
                        System.out.println("The last valid prime number is: " + s);
                        break;
                    }
                }
                isPrime = true;
                i += 1;

            }
            System.out.println("Enter number N: ");
            number = scan.nextInt();
            scan.nextLine();

            if (number < 0 ) {
                System.out.println("Terminating program...");
                System.out.println("Bye!");
                return;
            }

            if (number < 2) {
                System.out.println("N should not be less than 2");
                System.out.println("Enter number N: ");
                number = scan.nextInt();
                scan.nextLine();
            } else if (number > pow) {
                System.out.println("N should not be bigger than 1e9");
                System.out.println("Enter number N: ");
                number = scan.nextInt();
                scan.nextLine();
            }

            if (number < 0 ) {
                System.out.println("Terminating program...");
                System.out.println("Bye!");
                return;
            }


        } // end while loop

    }
}
