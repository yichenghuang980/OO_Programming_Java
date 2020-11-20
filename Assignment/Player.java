package HW1;
import java.util.ArrayList;

/**
 * Homework 7 -- Player
 *
 * This program gathers information about athletes.
 * It will then calculate their total attributes.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 4, 2020
 *
 *
 */

public class Player {
    private String firstName;
    private String lastName;
    private String position;
    private int shooting;
    private int passing;
    private int layup;
    private int athletics;
    private int defense;
    private int rebound;
    private ArrayList<String> skills;
    private int totalAttribute;

    public Player(String firstName, String lastName, String position,
                  int shooting, int passing, int layup, int athletics,
                  int defense, int rebound, ArrayList<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.shooting = shooting;
        this.passing = passing;
        this.layup = layup;
        this.athletics = athletics;
        this.defense = defense;
        this.rebound = rebound;
        this.skills = skills;
        this.totalAttribute = shooting + passing + layup + athletics + defense + rebound;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPosition() {
        return this.position;
    }

    public int getShooting() {
        return this.shooting;
    }

    public int getPassing() {
        return this.passing;
    }

    public int getLayup() {
        return this.layup;
    }

    public int getAthletics() {
        return this.athletics;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getRebound() {
        return this.rebound;
    }

    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public int getTotalAttribute() {
        return getShooting() + getPassing() + getLayup() + getAthletics() + getDefense() + getRebound();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setRebound(int rebound) {
        this.rebound = rebound;
    }

    public void setTotalAttribute(int totalAttribute) {
        this.totalAttribute = totalAttribute;
    }

    public boolean checkSkill(String skill) {
        return getSkills().contains(skill);
    }


}
