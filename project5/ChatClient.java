package project5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * This program will use user input to connect to a predefined server
 * and receive and send specific message based on instructions.
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 18, 2020
 */
final class ChatClient {
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    private final String server;
    private final String username;
    private final int port;

    private ChatClient(String username, int port, String server) {
        this.username = username;
        this.port = port;
        this.server = server;
    }

    /*
     * This starts the Chat Client
     */
    private boolean start() {
        // Create a socket
        try {
            socket = new Socket(server, port);
        } catch (IOException e) {
            System.out.println("Server is offline!");
        }

        // Create your input and output streams
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This thread will listen from the server for incoming messages
        Runnable r = new ListenFromServer();
        Thread t = new Thread(r);
        t.start();

        // After starting, send the clients username to the server.
        try {
            sOutput.writeObject(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void close() {
        try {
            sInput.close();
            sOutput.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * This method is used to send a ChatMessage Objects to the server
     */
    private void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * To start the Client use one of the following command
     * > java ChatClient
     * > java ChatClient username
     * > java ChatClient username portNumber
     * > java ChatClient username portNumber serverAddress
     *
     * If the portNumber is not specified 1500 should be used
     * If the serverAddress is not specified "localHost" should be used
     * If the username is not specified "Anonymous" should be used
     */
    public static void main(String[] args) {
        // Get proper arguments and override defaults
        Scanner scan = new Scanner(System.in);
        String userName = "Anonymous";
        int portNumber = 1500;
        String serverName = "localhost";

        if (args.length > 0) {
            switch (args.length) {
                case 1:
                    userName = args[0];
                    break;
                case 2:
                    userName = args[0];
                    portNumber = Integer.parseInt(args[1]);
                    break;
                case 3:
                    userName = args[0];
                    portNumber = Integer.parseInt(args[1]);
                    serverName = args[2];
                    break;
            }
        }

        // Create your client and start it
        ChatClient client = new ChatClient(userName, portNumber, serverName);
        client.start();
        System.out.println("Welcome! " + userName);

        while (true) {
            System.out.println("What do you want to do?\n'/logout' to exit\n'/list' to view " + "current clients\n" +
                    "'/msg' to send direct message\n'/chat' to send general message.");
            String command = scan.nextLine();
            switch (command.toLowerCase()) {
                case "/logout":
                    client.sendMessage(new ChatMessage("", 1, ""));
                    break;
                case "/list":
                    client.sendMessage(new ChatMessage("/list", 0, ""));
                    break;
                case "/msg":
                    System.out.println("Please specify the user you want to send messages to.");
                    String recipient = scan.nextLine();
                    System.out.println("What message do you want to send?");
                    String content = scan.nextLine();
                    client.sendMessage(new ChatMessage(content, 2, recipient));
                    break;
                default:
                    System.out.println("What message do you want to send?");
                    content = scan.nextLine();
                    client.sendMessage(new ChatMessage(content, 0, ""));
                    break;
            }
        }
    }

    /**
     * This is a private class inside of the ChatClient
     * It will be responsible for listening for messages from the ChatServer.
     * ie: When other clients send messages, the server will relay it to the client.
     *
     * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
     * @version April 18, 2020
     */
    private final class ListenFromServer implements Runnable {
        public void run() {
            try {
                while (true) {
                    String msg = (String) sInput.readObject();
                    if (msg.equals("close")) {
                        System.out.println("You are safely disconnected from the server!");
                        close();
                    }
                    System.out.print(msg);

                }

            } catch (IOException | ClassNotFoundException e) {
                close();
            }
        }
    }
}

