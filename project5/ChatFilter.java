package project5;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * This program will filter out bad words and replace them.
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 18, 2020
 */
public class ChatFilter {
    ArrayList<String> badWords = new ArrayList<>();

    public ChatFilter(String badWordsFileName) {
        try {
            File f = new File(badWordsFileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            while (true) {
                String line = bfr.readLine();
                if (line == null) {
                    break;
                }
                badWords.add(line);
            }
            bfr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String filter(String msg) {
        for (String badWord : badWords) {
            if (msg.toLowerCase().contains(badWord.toLowerCase())) {
                msg = msg.toLowerCase().replace(badWord.toLowerCase(), "**");
            }
        }
        return msg;
    }
}

