package HW1;

/**
 * Homework 5 -- Calculator
 *
 * This program uses Fields and Methods to simplify calculations for the user
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 19, 2020
 *
 */

public class Calculator {
    private double prevResult;
    private int count;

    public Calculator() { }

    public int add(int a, int b) {
        setPrevResult(b + a);
        updateCount();
        setCount(count);
        return b + a;
    }

    public int subtract(int a, int b) {
        setPrevResult(a - b);
        updateCount();
        setCount(count);
        return a - b;
    }

    public int multiply(int a, int b) {
        setPrevResult(a * b);
        updateCount();
        setCount(count);
        return a * b;
    }

    public double divide(int a, int b) {
        setPrevResult((double)a / b);
        updateCount();
        setCount(count);
        return (double)a / b;
    }

    public double calculateCircleArea(int r) {
        setPrevResult(Math.PI * (r * r));
        updateCount();
        setCount(count);
        return Math.PI * (r * r);
    }

    public int calculatePower(int a, int x) {
        setPrevResult((int)Math.pow(a, x));
        updateCount();
        setCount(count);
        return (int)Math.pow(a, x);
    }

    public double getPrevResult() {
        return this.prevResult;
    }

    public int getCount() {
        return this.count;
    }

    public void setPrevResult(double result) {
        this.prevResult = result;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void updateCount() {
        count += 1;
    }

}
