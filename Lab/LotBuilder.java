package lab;

/**
 * LotBuilder
 *
 * A class to simulate a parking lot using 2-D arrays.
 *
 *
 * @author Purdue CS
 * @version February 24th, 2020
 *
 */
public class LotBuilder {

    public static final String FULL = "|F|";
    public static final String EMPTY = "|_|";

    public String[][] generateLot(int num) {
        /* DO NOT CHANGE ANY CODE IN THIS FILE */
        if (num == 1 || num == 7) {
            return new String[][] {
                    {EMPTY, EMPTY, EMPTY, FULL},
                    {FULL, EMPTY, FULL, FULL},
                    {FULL, FULL, FULL, FULL},
                    {FULL, EMPTY, EMPTY, EMPTY},
                    {EMPTY, FULL, EMPTY, EMPTY},

            };



        } else if (num == 2) {
            return new String[][] {
                    {EMPTY, EMPTY, EMPTY, FULL, FULL},
                    {FULL, FULL, FULL, FULL, FULL},
                    {FULL, FULL, FULL, FULL, FULL},
                    {FULL, FULL, FULL, FULL, FULL},
                    {FULL, FULL, FULL, EMPTY, EMPTY},
            };

        } else if (num == 3 || num == 4) {
            return new String[][] {
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, FULL, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, FULL, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {FULL, FULL, FULL, EMPTY, EMPTY},
            };


        } else if (num == 5 || num == 6) {
            return new String[][] {
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, FULL, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, FULL, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {FULL, FULL, FULL, EMPTY, EMPTY},
            };


        } else {
            return new String[][] {
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                    {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            };


        }



    }

}
