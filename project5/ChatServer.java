package project5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * This program will wait for connection from clients and broadcast messages based on
 * the types of message.
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version April 18, 2020
 *
 * Help Source:
 * https://www.javatpoint.com/java-simpledateformat
 */
final class ChatServer {
    private static int uniqueId = 0;
    private final List<ClientThread> clients = new ArrayList<>();
    private final int port;
    private static Object block = new Object();
    private static String filterFile;

    private ChatServer(int port) {
        this.port = port;
    }

    /*
     * This is what starts the ChatServer.
     * Right now it just creates the socketServer and adds a new ClientThread to a list to be handled
     */
    private void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                Runnable r = new ClientThread(socket, uniqueId++);
                Thread t = new Thread(r);
                clients.add((ClientThread) r);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String message) {
        synchronized (block) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String strDate = formatter.format(date);
            message = strDate + " " + message;
            for (ClientThread client : clients) {
                client.writeMessage(message);
            }
            System.out.println(message);
        }
    }

    private void remove(int id) {
        synchronized (block) {
            clients.remove(id);
        }
    }

    /*
     *  > java ChatServer
     *  > java ChatServer portNumber
     *  If the port number is not specified 1500 is used
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int portNumber = 1500;
        if (args.length > 0) {
            portNumber = Integer.parseInt(args[0]);
        }
        filterFile = args[1];

        ChatFilter filter = new ChatFilter(filterFile);
        String displayBadWords = filter.badWords.get(0);
        for (int i = 1; i < filter.badWords.size(); i++) {
            displayBadWords += " " + filter.badWords.get(i);
        }
        System.out.println("Currently filtered bad words are: " + displayBadWords);

        ChatServer server = new ChatServer(portNumber);
        server.start();

    }


    /**
     * This is a private class inside of the ChatServer
     * A new thread will be created to run this every time a new client connects.
     *
     * @author your name and section
     * @version date
     */
    private final class ClientThread implements Runnable {
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id;
        String username;
        ChatMessage cm;

        private ClientThread(Socket socket, int id) {
            this.id = id;
            this.socket = socket;
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                username = (String) sInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        /*
         * This is what the client thread actually runs.
         */
        @Override
        public void run() {
            // read in bad words list
            ChatFilter filter = new ChatFilter(filterFile);
            // Read the username sent to you by client
            while (true) {
                try {
                    cm = (ChatMessage) sInput.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                // check if the username already exists

                // check if the client wants to log out
                switch (cm.getType()) {
                    // filter out bad words
                    case 0:
                        if (cm.getMessage().equals("/list")) {
                            String userList = clients.get(0).username;
                            for (int i = 1; i < clients.size(); i++) {
                                if (clients.get(i).username.equals(username)) {
                                    continue;
                                }
                                userList += " " + clients.get(i).username;
                            }
                            writeMessage("Currently connected users are: " + userList);
                            break;
                        }
                        String cleaned = filter.filter(cm.getMessage());
                        System.out.println(username + ": " + cleaned);
                        broadcast(cleaned);
                        break;
                    // remove the client
                    case 1:
                        int clientID = 0;
                        for (ClientThread client : clients) {
                            if (client.username.equals(username)) {
                                clientID = clients.indexOf(client);
                                break;
                            }
                        }
                        remove(clientID);
                        writeMessage("close");
                        broadcast(username + " has logged out.");
                        break;
                    // direct message
                    case 2:
                        for (ClientThread clientThread : clients) {
                            if (clientThread.username.equals(cm.getRecipient())) {
                                clientThread.writeMessage(cm.getMessage() + " from " + username);
                                break;
                            }
                        }
                        break;
                }
            }
        }

        private boolean writeMessage(String message) {
            if (socket.isClosed()) {
                return false;
            } else {
                try {
                    sOutput.writeObject(message);
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            }
        }

        private void close() {
            try {
                sInput.close();
                sOutput.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
