package HW1;

/**
 * Homework 10 -- IntegerSummer
 *
 * This program use threads to calculate counter
 * and return desired output in the end.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 01, 2020
 *
 *
 */

public class IntegerSummer implements Runnable {
    private static int counter = 0;
    //TODO: implement fields you feel are necessary
    private int start;
    private int end;
    private static Object block = new Object();

    /**
     *
     * @param start The start of the interval.
     * @param end The end of the interval.
     */
    public IntegerSummer(int start, int end) {
        //TODO: populate fields you feel are necessary
        this.start = start;
        this.end = end;
    }

    //TODO: implement the necessary method that will run when the thread is started
    public void run() {
        synchronized (block) {
            for (int i = start; i < end; i++) {
                counter += i;
            }
        }
    }
    /**
     *
     * @return The counter variable.
     */
    public static int getCounter() {
        //TODO: return the counter
        return counter;
    }

}
