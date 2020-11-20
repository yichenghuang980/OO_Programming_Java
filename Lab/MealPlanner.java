package lab;
import java.util.Scanner; // import Scanner class

public class MealPlanner {
    public static void main(String[] args) {
        System.out.println("Welcome to Purdue Meal Planner!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the appetizer?");
        String appetizer = scanner.nextLine();

        System.out.println("What is the main course?");
        String course = scanner.nextLine();

        System.out.println("What is the dessert?");
        String dessert = scanner.nextLine();

        System.out.println("Here is your summary!");

        System.out.println("Appetizer: " + appetizer);
        System.out.println("Main Course: " + course);
        System.out.println("Dessert: " + dessert);
        System.out.println("Thank you for using our program!");
    }
}
