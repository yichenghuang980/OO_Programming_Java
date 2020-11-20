package HW1;

import org.junit.*;
import java.lang.reflect.Field;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/**
 * IntegerSummerLocalTest
 *
 * A test case for IntegerSummer
 *
 * @author Purdue CS
 * @version 03/23/2020
 */
public class IntegerSummerLocalTest {

    @Test
    public void threadTestOne() {
        runTest(0, 1000, 10);
        resetCounter();
    }

    /* utility methods below */

    public void resetCounter() {
        Class<IntegerSummer> clazz = IntegerSummer.class;

        try {
            Field counter = clazz.getDeclaredField("counter");
            counter.setAccessible(true);
            counter.set(counter, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void runTest(int start, int end, int numThreads) {

        IntegerSummer[] threadArr = new IntegerSummer[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threadArr[i] = new IntegerSummer(start, end);
        }

        Object erasedType = threadArr[0];

        if (erasedType instanceof Thread) {

            for (int i = 0; i < numThreads; i++) {
                Object eraser = threadArr[i];
                if (eraser instanceof Thread) {
                    ((Thread)eraser).start();
                }
            }

            try {
                for (int i = 0; i < numThreads; i++) {
                    Object eraser = threadArr[i];
                    if (eraser instanceof Thread) {
                        ((Thread)eraser).join();
                    }
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            int expected = 0;
            for (int i = start; i < end; i++) {
                expected += i;
            }

            expected *= numThreads;

            assertEquals("The sum is incorrect.", expected, threadArr[0].getCounter());
        } else {
            Thread[] instantiatedThreadArr = new Thread[numThreads];

            for (int i = 0; i < numThreads; i++) {
                instantiatedThreadArr[i] = new Thread(threadArr[i]);
                instantiatedThreadArr[i].start();
            }

            try {
                for (int i = 0; i < numThreads; i++) {
                    instantiatedThreadArr[i].join();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            int expected = 0;
            for (int i = start; i < end; i++) {
                expected += i;
            }

            expected *= numThreads;

            assertEquals("The sum is incorrect.", expected, threadArr[0].getCounter());
        }
    }
}

