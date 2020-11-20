package project4;

/**
 * Project 4 -- InvalidStateException
 *
 * This program pops up exception when state name is invalid.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 6, 2020
 *
 */

public class InvalidStateException extends Exception {
    public InvalidStateException() { }
    public InvalidStateException(String message) {
        super(message);
    }
}
