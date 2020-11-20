package HW1;

import java.util.Scanner; // import Scanner class

/**
 * Homework 3 -- Selection
 *
 * This program uses Scanner to prompt the user for yes/no answer to a
 * series of questions. Based on these answers, it will determine the specific
 * type of tree the user describes.
 *
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 3, 2020
 *
 */

public class Selection {

    static final String QUESTION1 = "Does your tree have compound leaves?";
    static final String QUESTION2 = "Does your tree have 7 or fewer leaflets?";
    static final String QUESTION3 = "Are the leaflets rounded?";
    static final String QUESTION4 = "Is the leaf 6-8 inches long?";
    static final String QUESTION5 = "Are the leaves lobed?";
    static final String QUESTION6 = "Is the bark papery?";
    static final String QUESTION7 = "Are the leaf petioles flat?";
    static final String QUESTION8 = "Are the leaves triangular?";
    static final String QUESTION9 = "Is the leaf width equal to the length?";
    static final String QUESTION10 = "Are the leaves finely toothed?";
    static final String QUESTION11 = "Is the leaf at least 3 times longer than the width?";
    static final String QUESTION12 = "Are the leaf veins thin?";
    static final String QUESTION13 = "Is the bark dark?";
    static final String QUESTION14 = "Are the leaves shiny";
    static final String QUESTION15 = "Is the leaf base even?";
    static final String ERROR = "There was an error!";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yes = "y";
        String no = "n";

        System.out.println("Let's see what kind of tree you have!");
        System.out.println("-------------------------------------");

        System.out.println(QUESTION1);
        String a1 = scan.nextLine();
        if (a1.equals(yes)) {
            System.out.println(QUESTION2);
            String a2 = scan.nextLine();
            if (a2.equals(yes)) {
                System.out.println("Your tree: Shagbark Hickory!");
            } else if (a2.equals(no)) {
                System.out.println(QUESTION3);
                String a3 = scan.nextLine();
                if (a3.equals(yes)) {
                    System.out.println("Your tree: Black Locust!");
                } else if (a3.equals(no)) {
                    System.out.println(QUESTION4);
                    String a4 = scan.nextLine();
                    if (a4.equals(yes)) {
                        System.out.println("Your tree: Mountain Ash!");
                    } else if (a4.equals(no)) {
                        System.out.println("Your tree: Black Walnut!");
                    } else {
                        System.out.println(ERROR);
                    }
                } else {
                    System.out.println(ERROR);
                }
            } else {
                System.out.println(ERROR);
            }
        } else if (a1.equals(no)) {
            System.out.println(QUESTION5);
            String a5 = scan.nextLine();
            if (a5.equals(yes)) {
                System.out.println("Your tree: Oak!");
            } else if (a5.equals(no)) {
                System.out.println(QUESTION6);
                String a6 = scan.nextLine();
                if (a6.equals(yes)) {
                    System.out.println("Your tree: Birch!");
                } else if (a6.equals(no)) {
                    System.out.println(QUESTION7);
                    String a7 = scan.nextLine();
                    if (a7.equals(yes)) {
                        System.out.println(QUESTION8);
                        String a8 = scan.nextLine();
                        switch (a8) {
                            case "y": System.out.println("Your tree: Eastern Cottonwood!");
                              break;
                            case "n": System.out.println("Your tree: Aspen!");
                              break;
                            default: System.out.println(ERROR);
                        }

                    } else if (a7.equals(no)) {
                        System.out.println(QUESTION9);
                        String a9 = scan.nextLine();
                        if (a9.equals(yes)) {
                            System.out.println(QUESTION10);
                            String a10 = scan.nextLine();
                            switch (a10) {
                                case "y": System.out.println("Your tree: Balsam Poplar!");
                                  break;
                                case "n": System.out.println("Your tree: Basswood!");
                                  break;
                                default: System.out.println(ERROR);
                            }

                        } else if (a9.equals(no)) {
                            System.out.println(QUESTION11);
                            String a11 = scan.nextLine();
                            if (a11.equals(yes)) {
                                System.out.println("Your tree: Willow!");

                            } else if (a11.equals(no)) {
                                System.out.println(QUESTION12);
                                String a12 = scan.nextLine();
                                if (a12.equals(yes)) {
                                    System.out.println(QUESTION13);
                                    String a13 = scan.nextLine();
                                    switch (a13) {
                                        case "y": System.out.println("Your tree: Black Cherry!");
                                          break;
                                        case "n": System.out.println("Your tree: Hackberry!");
                                          break;
                                        default: System.out.println(ERROR);
                                    }

                                } else if (a12.equals(no)) {
                                    System.out.println(QUESTION14);
                                    String a14 = scan.nextLine();
                                    if (a14.equals(yes)) {
                                        System.out.println("Your tree: Beech!");
                                    } else if (a14.equals(no)) {
                                        System.out.println(QUESTION15);
                                        String a15 = scan.nextLine();
                                        switch (a15) {
                                            case "y": System.out.println("Your tree: Ironwood!");
                                              break;
                                            case "n": System.out.println("Your tree: Elm!");
                                              break;
                                            default: System.out.println(ERROR);
                                        }
                                    } else {
                                        System.out.println(ERROR);
                                    }
                                } else {
                                    System.out.println(ERROR);
                                }

                            } else {
                                System.out.println(ERROR);
                            }

                        } else {
                            System.out.println(ERROR);
                        }

                    } else {
                        System.out.println(ERROR);
                    }

                } else {
                    System.out.println(ERROR);
                }

            } else {
                System.out.println(ERROR);
            }
        } else {
            System.out.println(ERROR);
        }

    }
}