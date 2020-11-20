package HW1;
import static java.lang.Math.sqrt;

/**
 * Homework 9 -- Icosidodecahedron
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

public class Icosidodecahedron extends ArchimedeanSolid {

    public Icosidodecahedron(double edgeLength) {
        super(edgeLength);
    }

    public boolean equals(Object object) {
        return object instanceof Icosidodecahedron && ((Icosidodecahedron) object).getEdgeLength() == getEdgeLength();
    }

    public String toString() {
        String res = String.format("Icosidodecahedron[%.6f]", getEdgeLength());
        return res;
    }

    public double getVolume() {
        return ((45.0 + (17.0 * sqrt(5.0))) / 6.0) * (getEdgeLength() * getEdgeLength() * getEdgeLength());
    }

    public double getSurfaceArea() {
        return ((5.0 * sqrt(3.0)) + (3.0 * sqrt(25.0 + (10.0 * sqrt(5.0))))) * (getEdgeLength() * getEdgeLength());
    }
}
