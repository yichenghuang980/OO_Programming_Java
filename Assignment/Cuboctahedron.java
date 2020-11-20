package HW1;
import static java.lang.Math.sqrt;

/**
 * Homework 9 -- Cuboctahedron
 *
 * This program creates extends ArchimedeanSolid and implement its
 * methods.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 26, 2020
 *
 *
 */

public class Cuboctahedron extends ArchimedeanSolid {

    public Cuboctahedron(double edgeLength) {
        super(edgeLength);
    }

    public boolean equals(Object object) {
        return object instanceof Cuboctahedron && ((Cuboctahedron) object).getEdgeLength() == getEdgeLength();
    }

    public String toString() {
        String res = String.format("Cuboctahedron[%.6f]", getEdgeLength());
        return res;
    }

    public double getVolume() {
        return (5.0 / 3.0) * sqrt(2.0) * (getEdgeLength() * getEdgeLength() * getEdgeLength());
    }

    public double getSurfaceArea() {
        return (6.0 + (2.0 * sqrt(3.0))) * (getEdgeLength() * getEdgeLength());
    }
}
