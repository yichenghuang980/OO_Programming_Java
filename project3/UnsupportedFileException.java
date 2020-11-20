package project3;

/**
 * Project 3 -- UnsupportedFileException
 *
 * This program throws exception when the input is not valid.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 15, 2020
 *
 */

public class UnsupportedFileException extends Exception {
    public UnsupportedFileException(String message) {
        super(message);
    }
}
