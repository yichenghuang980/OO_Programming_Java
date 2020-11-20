package lab;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BusinessCard {
    public static void main (String[] args) {
        int reply = JOptionPane.showConfirmDialog(null,
                "Would you like to generate a business card?",
                "Business Card Generator",
                JOptionPane.YES_NO_OPTION);

        while (reply != JOptionPane.NO_OPTION) {

            ArrayList<String> cardContent = new ArrayList<>();
            String name = JOptionPane.showInputDialog(null,
                    "What is your name?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            cardContent.add(name);
            String age = JOptionPane.showInputDialog(null,
                    "What is your age?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            cardContent.add(age);
            String gpa = JOptionPane.showInputDialog(null,
                    "What is your GPA?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            cardContent.add(gpa);
            String major = JOptionPane.showInputDialog(null,
                    "What is your major?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            cardContent.add(major);
            String email = JOptionPane.showInputDialog(null,
                    "What is your email?",
                    "Business Card Generator", JOptionPane.QUESTION_MESSAGE);
            cardContent.add(email);

            JOptionPane.showMessageDialog(null,
                    String.format("Name: %s\nAge: %s\nGPA: %s\nMajor: %s\nEmail: %s", cardContent.get(0),
                            cardContent.get(1), cardContent.get(2), cardContent.get(3), cardContent.get(4)),
                    "Business Card Generator", JOptionPane.INFORMATION_MESSAGE);

            reply = JOptionPane.showConfirmDialog(null,
                    "Would you like to generate another business card?",
                    "Business Card Generator",
                    JOptionPane.YES_NO_OPTION);
        }
    }
}
