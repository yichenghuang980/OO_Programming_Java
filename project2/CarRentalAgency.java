package project2;
import java.util.Scanner;

/**
 * Project 2 -- CarRentalAgency
 *
 * This program uses Scanner to prompt the user for service
 * that he wants and then gather information and user other
 * predefined classes to calculate final cost.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 27, 2020
 *
 */

public class CarRentalAgency {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Car carInfo = new Car();
        Employee employeeInfo = new Employee();
        Customer consumeInfo = new Customer();
        System.out.println("Hello! What would you like to do?");

        while (true) {
            System.out.println("1. Rent a Car");
            System.out.println("2. Buy a Car");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Quit");

            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 4) {
                System.out.println("Shutting down the program!");
                return;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid input!");
                System.out.println("Please enter a number between 1 and 4!");
                continue;
            }

            switch (choice) {
                case 3:
                    System.out.println("Please enter the Employee's information.");
                    System.out.println("Name: ");
                    String employee = scan.nextLine();
                    employeeInfo.setName(employee);
                    System.out.println("Years Worked: ");
                    while (true) {
                        int year = scan.nextInt();
                        scan.nextLine();
                        if (year >= 0) {
                            employeeInfo.setYearsWorked(year);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Total Rentals: ");
                    while (true) {
                        int rental = scan.nextInt();
                        scan.nextLine();
                        if (rental >= 0) {
                            employeeInfo.setTotalRentals(rental);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Base Salary: ");
                    while (true) {
                        double salary = scan.nextDouble();
                        scan.nextLine();
                        if (salary >= 0) {
                            employeeInfo.setBaseSalary(salary);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("id: ");
                    while (true) {
                        int id = scan.nextInt();
                        scan.nextLine();
                        if (id >= 0) {
                            employeeInfo.setId(id);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }

                    System.out.printf("%s's salary is: $%.2f.",
                            employeeInfo.getName(), employeeInfo.calculateSalary());
                    break;

                case 4:
                    System.out.println("Shutting down the program!");
                    return;

                default:
                    System.out.println("Please enter the Customer's information: ");
                    System.out.println("Name: ");
                    String customer = scan.nextLine();
                    consumeInfo.setName(customer);
                    System.out.println("Address: ");
                    String address = scan.nextLine();
                    consumeInfo.setAddress(address);
                    System.out.println("Zip Code: ");
                    String zipCode = scan.nextLine();
                    consumeInfo.setZipCode(zipCode);
                    System.out.println("Number of Previous Rentals: ");
                    while (true) {
                        int numRental = scan.nextInt();
                        scan.nextLine();
                        if (numRental >= 0) {
                            consumeInfo.setNumRentals(numRental);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Please enter the Car's information: ");
                    System.out.println("Classification Type: ");

                    String rawType = scan.nextLine();
                    Classification type = Classification.valueOf(rawType);
                    carInfo.setType(type);

                    System.out.println("Max Seating: ");
                    while (true) {
                        int maxSeating = scan.nextInt();
                        scan.nextLine();
                        if (maxSeating >= 0) {
                            carInfo.setMaxSeating(maxSeating);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Towing Capacity: ");
                    while (true) {
                        int towingCapacity = scan.nextInt();
                        scan.nextLine();
                        if (towingCapacity >= 0) {
                            carInfo.setTowingCapacity(towingCapacity);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Fuel Economy: ");
                    while (true) {
                        double fuelEconomy = scan.nextDouble();
                        scan.nextLine();
                        if (fuelEconomy >= 0) {
                            carInfo.setFuelEconomy(fuelEconomy);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Make: ");
                    String make = scan.nextLine();
                    carInfo.setMake(make);
                    System.out.println("Model: ");
                    String model = scan.nextLine();
                    carInfo.setModel(model);
                    System.out.println("vin: ");
                    String vin = scan.nextLine();
                    carInfo.setVin(vin);
                    System.out.println("Purchase Price: ");
                    while (true) {
                        double purchasePrice = scan.nextDouble();
                        scan.nextLine();
                        if (purchasePrice >= 0) {
                            carInfo.setPurchasePrice(purchasePrice);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }
                    System.out.println("Mileage: ");
                    while (true) {
                        int mileage = scan.nextInt();
                        scan.nextLine();
                        if (mileage >= 0) {
                            carInfo.setMileage(mileage);
                            break;
                        }
                        System.out.println("Invalid input!");
                        System.out.println("Please enter a number greater than or equal to 0.");
                    }

                    if (choice == 1) {
                        System.out.printf("Does %s want insurance? %n", consumeInfo.getName());
                        while (true) {
                            boolean wantInsure = false;
                            String insurance = scan.nextLine();
                            if (insurance.substring(0, 1).toLowerCase().equals("y")) {
                                wantInsure = true;
                                System.out.println("How many days are in the rental period?");
                                while (true) {
                                    int numDays = scan.nextInt();
                                    scan.nextLine();
                                    if (numDays >= 0) {
                                        System.out.printf("The total price is: $%.2f.",
                                                carInfo.calculateRate(numDays, wantInsure) *
                                                        (1.0 - consumeInfo.calculateDiscount()));
                                        break;
                                    }
                                    System.out.println("Invalid input!");
                                    System.out.println("Please enter a number greater than or equal to 0.");
                                }
                                break;
                            } else if (insurance.substring(0, 1).toLowerCase().equals("n")) {
                                wantInsure = false;
                                System.out.println("How many days are in the rental period?");
                                while (true) {
                                    int numDays = scan.nextInt();
                                    scan.nextLine();
                                    if (numDays >= 0) {
                                        System.out.printf("The total price is: $%.2f.",
                                                carInfo.calculateRate(numDays, wantInsure) *
                                                        (1.0 - consumeInfo.calculateDiscount()));
                                        break;
                                    }
                                    System.out.println("Invalid input!");
                                    System.out.println("Please enter a number greater than or equal to 0.");
                                }
                                break;
                            }
                            System.out.println("Invalid input!");
                            System.out.println("Please enter either Yes/yes/y or No/no/n.");
                        }

                    } else {
                        System.out.printf("The total price is: $%.2f.", carInfo.calculateSellPrice());
                    }
                    break;

            }
        }
    }
}
