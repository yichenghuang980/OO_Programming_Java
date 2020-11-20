package project5;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * This program will encode client message to distinguish
 * different clients and also allow direct message sending.
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 18, 2020
 */
final class ChatMessage implements Serializable {
    private static final long serialVersionUID = 6898543889087L;

    // Here is where you should implement the chat message object.
    // Variables, Constructors, Methods, etc.
    private String message;
    private int type;
    private String recipient;

    public ChatMessage(String message, int type, String recipient) {
        this.message = message;
        this.type = type;
        this.recipient = recipient;
    }

    public void directMessage(String message, String username) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String strDate = formatter.format(date);
        String newMessage = strDate + " " + message;
    }

    public String getMessage() {
        return this.message;
    }
    public int getType() {
        return this.type;
    }
    public String getRecipient() {
        return this.recipient;
    }
}

