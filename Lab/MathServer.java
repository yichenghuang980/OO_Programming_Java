package lab;

import java.io.*;
import java.net.*;

public class MathServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("Waiting for the client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        String first = reader.readLine();
        String second = reader.readLine();
        String mode = reader.readLine();
        String response;

        switch (mode) {
            case "1":
                response = Integer.toString(Integer.parseInt(first) + Integer.parseInt(second));
                break;
            case "2":
                response = Integer.toString(Integer.parseInt(first) - Integer.parseInt(second));
                break;
            case "3":
                response = Integer.toString(Integer.parseInt(first) * Integer.parseInt(second));
                break;
            default:
                response = Integer.toString(Integer.parseInt(first) / Integer.parseInt(second));
                break;
        }
        writer.write(response);
        writer.newLine();
        writer.flush();

        writer.close();
        reader.close();
    }
}
