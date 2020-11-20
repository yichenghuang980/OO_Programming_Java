package project4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project 4 -- IndianaStudent
 *
 * This program extends CollegeStudent and implements its methods
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 6, 2020
 *
 */

public class IndianaStudent extends CollegeStudent {
    private static ArrayList<String> idNums = new ArrayList<>();

    public IndianaStudent(int age, String firstName, String lastName, String stateOfResidency,
                          String major, String housing) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateOfResidency = stateOfResidency;
        this.major = major;
        this.housing = housing;
    }

    public IndianaStudent(String id) {
        this.id = id;
    }

    public IndianaStudent() { }

    public double getTuition() {
        return this.tuition;
    }
    public int getStudentAge() {
        return this.age;
    }
    public String getStudentFirstName() {
        return this.firstName;
    }
    public String getStudentLastName() {
        return this.lastName;
    }
    public String getStateOfResidence() {
        return this.stateOfResidency;
    }
    public String getFullName() {
        return getStudentFirstName() + " " + getStudentLastName();
    }
    public void calculateTuition() {
        if (getStateOfResidence().equals(getState())) {
            this.tuition = CollegeConstants.INDIANA_UNIVERSITY_IN_STATE_TUITION;
        } else {
            this.tuition = CollegeConstants.INDIANA_UNIVERSITY_OUT_OF_STATE_TUITION;
        }
    }
    public String getMajor() {
        return this.major;
    }
    public String getHousing() {
        return this.housing;
    }
    public String getState() {
        return CollegeConstants.INDIANA_UNIVERSITY_STATE;
    }
    public String generateID() {
        Random random = new Random();
        while (true) {
            boolean repeat = false;
            id = "8";
            for (int i = 0; i < 7; i++) {
                int digit = random.nextInt(10);
                id += digit;
            }
            id += "21";
            for (String newId : idNums) {
                if (id.equals(newId)) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                idNums.add(id);
                return id;
            }
        }
    }
    public String getID() {
        return this.id;
    }
}
