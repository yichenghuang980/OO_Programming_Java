package HW1;
import java.util.ArrayList;

/**
 * Homework 7 -- PlayerList
 *
 * This program stores a list of players
 * It will then calculate the best player for each position.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 4, 2020
 *
 *
 */

public class PlayerList {

    private ArrayList<Player> players;

    public PlayerList(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
    }

    public Player findPG() {
        int maxDefense = 0;
        Player bestPG = getPlayers().get(0);
        int pgCount = 0;

        for (int i = 0; i < getPlayers().size(); i++) {
            Player element = getPlayers().get(i);
            if (!element.getPosition().equals("PG")) {
                continue;
            }
            int pgSum = element.getShooting() + element.getPassing() + element.getLayup();
            if (pgSum > 280 && element.checkSkill("Point Phenom")) {
                pgCount += 1;
                if (element.getDefense() > maxDefense) {
                    maxDefense = element.getDefense();
                    bestPG = element;
                }
            }
        }
        if (pgCount == 0) {
            for (int i = 0; i < getPlayers().size(); i++) {
                Player element = getPlayers().get(i);
                if (element.getPosition().equals("PG")) {
                    bestPG = element;
                    break;
                }
            }
        }
        return bestPG;
    }

    public Player findSG() {
        int maxSum = 0;
        Player bestSG = getPlayers().get(0);
        int sgCount = 0;

        for (int i = 0; i < getPlayers().size(); i++) {
            Player element = getPlayers().get(i);
            if (!element.getPosition().equals("SG")) {
                continue;
            }
            if (element.checkSkill("GOAT")) {
                bestSG = element;
                sgCount += 1;
                break;
            }
            int sgSum = element.getShooting() + element.getPassing() + element.getLayup()
                    + element.getDefense() + element.getAthletics();
            if (sgSum > maxSum) {
                maxSum = sgSum;
                bestSG = element;
                sgCount += 1;
            }
        }
        if (sgCount == 0) {
            for (int i = 0; i < getPlayers().size(); i++) {
                Player element = getPlayers().get(i);
                if (element.getPosition().equals("SG")) {
                    bestSG = element;
                    break;
                }
            }
        }
        return bestSG;
    }

    public Player findSF() {
        int maxSum = 0;
        Player bestSF = getPlayers().get(0);
        int sfCount = 0;
        for (int i = 0; i < getPlayers().size(); i++) {
            Player element = getPlayers().get(i);
            if (!element.getPosition().equals("SF")) {
                continue;
            }
            if (element.checkSkill("The King") || element.checkSkill("Floor General")) {
                sfCount += 1;
                int sfSum = element.getTotalAttribute();
                if (sfSum > maxSum) {
                    maxSum = sfSum;
                    bestSF = element;
                }
            }
        }
        if (sfCount == 0) {
            for (int i = 0; i < getPlayers().size(); i++) {
                Player element = getPlayers().get(i);
                if (element.getPosition().equals("SF")) {
                    bestSF = element;
                    break;
                }
            }
        }
        return bestSF;
    }

    public Player findPF() {
        int maxSum = 0;
        Player bestPF = getPlayers().get(0);
        int pfCount = 0;

        for (int i = 0; i < getPlayers().size(); i++) {
            Player element = getPlayers().get(i);
            if (!element.getPosition().equals("PF")) {
                continue;
            }
            if (element.getShooting() > 80 || element.getLayup() > 95) {
                pfCount += 1;
                int pfSum = element.getDefense() + element.getRebound() + element.getAthletics();
                if (pfSum > maxSum) {
                    maxSum = pfSum;
                    bestPF = element;
                }
            }
        }
        if (pfCount == 0) {
            for (int i = 0; i < getPlayers().size(); i++) {
                Player element = getPlayers().get(i);
                if (element.getPosition().equals("PF")) {
                    bestPF = element;
                    break;
                }
            }
        }
        return bestPF;
    }

    public Player findC() {
        int maxSum = 0;
        Player bestC = getPlayers().get(0);
        int cCount = 0;

        for (int i = 0; i < getPlayers().size(); i++) {
            Player element = getPlayers().get(i);
            if (!element.getPosition().equals("C")) {
                continue;
            }
            if (element.checkSkill("Paint Dominator")) {
                cCount += 1;
                int cSum = element.getDefense() + element.getRebound() + element.getAthletics() +
                        element.getShooting() + element.getLayup();
                if (cSum > maxSum) {
                    maxSum = cSum;
                    bestC = element;
                }
            }
        }
        if (cCount == 0) {
            for (int i = 0; i < getPlayers().size(); i++) {
                Player element = getPlayers().get(i);
                if (element.getPosition().equals("C")) {
                    bestC = element;
                    break;
                }
            }
        }
        return bestC;
    }
}
