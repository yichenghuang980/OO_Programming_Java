package HW1;

/**
 * Homework 9 -- ArchimedeanSolid
 *
 * This program creates an abstract class for further extension and
 * implementation.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 26, 2020
 *
 *
 */

public abstract class ArchimedeanSolid {
    private double edgeLength;

    public ArchimedeanSolid(double edgeLength) {
        if (edgeLength < 0) {
            throw new IllegalArgumentException("Input is negative!");
        }
        setEdgeLength(edgeLength);
    }

    public boolean equals(Object object) {
        return object instanceof ArchimedeanSolid && ((ArchimedeanSolid) object).getEdgeLength() == getEdgeLength();
    }

    public double getEdgeLength() {
        return this.edgeLength;
    }

    public String toString() {
        String res = String.format("ArchimedeanSolid[%.6f]", getEdgeLength());
        return res;
    }

    public abstract double getVolume();
    public abstract double getSurfaceArea();
    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }
}
