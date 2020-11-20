package project4;

/**
 * Project 4 -- InvalidStudentException
 *
 * This program pops up exception when student name is invalid.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 6, 2020
 *
 */

public class InvalidStudentException extends Exception {
    public InvalidStudentException() { }
    public InvalidStudentException(String message) {
        super(message);
    }
}
