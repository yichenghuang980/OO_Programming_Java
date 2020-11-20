package project4;

/**
 * Project 4 -- InvalidCollegeException
 *
 * This program pops up exception when college name is invalid.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 6, 2020
 *
 */

public class InvalidCollegeException extends Exception {
    public InvalidCollegeException() { }
    public InvalidCollegeException(String message) {
        super(message);
    }
}
