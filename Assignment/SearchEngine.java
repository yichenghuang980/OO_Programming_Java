package HW1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * Homework 7 -- SearchEngine
 *
 * This program prompts the user for text file.
 * It will then select out the roster and write it into a new file.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 4, 2020
 *
 *
 */

public class SearchEngine {

    public static PlayerList readFile(String fileName) throws IOException, UnsupportedRosterException {
        ArrayList<Player> playerInfo = new ArrayList<>();
        PlayerList playerList = new PlayerList(playerInfo);

        File f = new File(fileName);
        if (!f.exists()) {
            throw new FileNotFoundException();
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            int countPG = 0;
            int countSG = 0;
            int countSF = 0;
            int countPF = 0;
            int countC = 0;

            while (true) {
                String[] detailList;
                String line = bfr.readLine();
                if (line == null) {
                    break;
                }
                detailList = line.split(" ", 10);

                switch (detailList[2]) {
                    case "PG":
                        countPG += 1;
                        break;
                    case "SG":
                        countSG += 1;
                        break;
                    case "SF":
                        countSF += 1;
                        break;
                    case "PF":
                        countPF += 1;
                        break;
                    case "C":
                        countC += 1;
                        break;
                }

                for (int i = 3; i < detailList.length - 2; i++) { // check attribute range
                    if (Integer.parseInt(detailList[i]) < 0 || Integer.parseInt(detailList[i]) > 100) {
                        throw new UnsupportedRosterException("Attribute out of range!");
                    }
                }

                ArrayList<String> skillList = new ArrayList<>(
                        Arrays.asList(detailList[detailList.length - 1].split(",")));
                Player individual = new Player(detailList[0], detailList[1], detailList[2],
                        Integer.parseInt(detailList[3]), Integer.parseInt(detailList[4]),
                        Integer.parseInt(detailList[5]), Integer.parseInt(detailList[6]),
                        Integer.parseInt(detailList[7]), Integer.parseInt(detailList[8]),
                        skillList);
                playerList.addPlayer(individual);
            }
            bfr.close();

            if (countPG == 0 || countSG == 0 || countSF == 0 || countPF == 0 || countC == 0) {
                throw new UnsupportedRosterException("At least one player for each position!");
            } // check if there is no record about one position
        }
        return playerList;
    }

    public static void writeFile(ArrayList<Player> startup, String output) throws IOException {
        File outputFile = new File(output);
        FileOutputStream fos = new FileOutputStream(outputFile);
        PrintWriter pw = new PrintWriter(fos);

        if (outputFile.createNewFile()) {
            for (Player element : startup) {
                String newContent = element.getFirstName() + " " +
                        element.getLastName() + " " + element.getPosition() +
                        " " + element.getTotalAttribute();
                pw.println(newContent);
            }
        } else {
            for (Player element : startup) {
                String newContent = element.getFirstName() + " " +
                        element.getLastName() + " " + element.getPosition() +
                        " " + element.getTotalAttribute();
                pw.println(newContent);
            }
        }
        pw.close();
    }

    public static ArrayList<Player> findPlayer(PlayerList list) {
        ArrayList<Player> newList = new ArrayList<>();
        newList.add(list.findPG());
        newList.add(list.findSG());
        newList.add(list.findSF());
        newList.add(list.findPF());
        newList.add(list.findC());
        return newList;
    }

    public static void main(String[] args) throws IOException, UnsupportedRosterException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the input file name:");
        String input = scan.nextLine();
        System.out.println("Please enter the output file name:");
        String output = scan.nextLine();

        writeFile(findPlayer(readFile(input)), output);

    }
}