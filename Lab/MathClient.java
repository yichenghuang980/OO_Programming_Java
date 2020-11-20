package lab;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4242);
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        System.out.println("Enter the First Value");
        String first = scan.nextLine();

        System.out.println("Enter the Second Value");
        String second = scan.nextLine();

        System.out.println("Enter the Mode");
        String mode = scan.nextLine();

        writer.write(first);
        writer.newLine();
        writer.write(second);
        writer.newLine();
        writer.write(mode);
        writer.newLine();
        writer.flush();

        String s1 = reader.readLine();
        System.out.printf("Response from the server: %s", s1);

        writer.close();
        reader.close();
    }
}
