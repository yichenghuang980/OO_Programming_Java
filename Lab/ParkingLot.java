package lab;

import java.util.Scanner;

/**
 * Lab 07 - ParkingLot
 *
 * A program that allows a user to park a car in a simulated parking lot.
 *
 *
 * @author Purdue CS
 * @version February 24th, 2020
 *
 */
public class ParkingLot {
    public static void main(String[] args) {

        LotBuilder lot = new LotBuilder();
        Scanner scan = new Scanner(System.in);
        int num;
        if (args.length == 0) {
            num = 0;
        } else {
            num = Integer.parseInt(args[0]);
        }

        String[][] arr = lot.generateLot(num);

        /* DO NOT CHANGE ANY OF THE CODE ABOVE */
        for (String [] digit : arr) {
            for (String word : digit) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

        System.out.println("Enter the row you would like to park in: ");
        System.out.println("Row: ");
        int row = scan.nextInt();
        scan.nextLine();
        if (row == -1) {
            System.out.println("Thank you for using the program!");
            return;
        }
        boolean canPark = true;

        while (row != -1) {

            if (row == -1) {
                System.out.println("Thank you for using the program!");
                return;
            }

            if (row >= arr.length || row < 0) {
                System.out.println("Please make sure your request is in range.");
                System.out.println("Enter the row you would like to park in: ");
                System.out.println("Row: ");
                row = scan.nextInt();
                scan.nextLine();
                if (row == -1) {
                    System.out.println("Thank you for using the program!");
                    return;
                }
                continue;
            }


            if (row < arr.length) {
                for (int i = 0; i < arr[row].length; i++) {

                    if (arr[row][i].equals("|F|") && i != arr[row].length - 1) {
                        continue;
                    }

                    if (arr[row][i].equals("|F|") && i == arr[row].length - 1) {
                        System.out.println("Sorry, that row is full! Please pick another row.");
                        canPark = false;
                        break;
                    }
                    else {
                        arr[row] [i] = "|F|";
                        System.out.println("You have parked successfully!");
                        break;
                    }
                }

            }
            if (canPark) {
                for (String [] digit : arr) {
                    for (String word : digit) {
                        System.out.print(word + " ");
                    }
                    System.out.println();
                }
            }
            canPark = true;

            System.out.println("Enter the row you would like to park in: ");
            System.out.println("Row: ");
            row = scan.nextInt();
            scan.nextLine();
            if (row == -1) {
                System.out.println("Thank you for using the program!");
                return;
            } else {
                continue;
            }
        } // end while loop




    }

}
