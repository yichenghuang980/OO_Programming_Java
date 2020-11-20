package HW1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * A server used to obtain the years, months, and days until a date requested by a client.
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- Network I/O -- Homework</p>
 *
 * @author Purdue CS
 * @version April 6, 2020
 */
public final class CountdownClient {
    /**
     * Determines whether or not the specified {@code String} is parsable as a non-negative {@code int}.
     *
     * @param string the {@code String} to be used in the operation
     * @return {@code true}, if the specified {@code String} is parsable as a non-negative {@code int} and
     * {@code false} otherwise
     */
    private static boolean isParsable(String string) {
        return string.chars()
                .mapToObj(Character::isDigit)
                .reduce(Boolean::logicalAnd)
                .orElse(Boolean.FALSE);
    } //isParsable

    /**
     * Connects to a {@code CountdownServer} instance and sends requests.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        String hostname;
        String portString;
        int port;
        Socket socket;
        BufferedWriter socketWriter = null;
        BufferedReader socketReader = null;
        String request;
        String response;

        try {
            System.out.print("Enter the server's hostname: ");

            hostname = userInputReader.readLine();

            if (hostname == null) {
                System.out.println();

                System.out.println("Goodbye!");

                return;
            } //end if

            System.out.println();

            System.out.print("Enter the server's port: ");

            portString = userInputReader.readLine();

            if (portString == null) {
                System.out.println();

                System.out.println("Goodbye!");

                return;
            } else if (!isParsable(portString)) {
                System.out.println();

                System.out.println("Error: the specified port must be a non-negative integer!");

                System.out.println();

                System.out.println("Goodbye!");

                return;
            } else {
                port = Integer.parseInt(portString);
            } //end if

            socket = new Socket(hostname, port);

            socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println();

            System.out.print("Enter your request: ");

            request = userInputReader.readLine();

            while (request != null) {
                socketWriter.write(request);

                socketWriter.newLine();

                socketWriter.flush();

                response = socketReader.readLine();

                System.out.println();

                System.out.printf("Response from the server: %s%n", response);

                System.out.println();

                System.out.print("Enter your request: ");

                request = userInputReader.readLine();
            } //end while

            System.out.println();

            System.out.println("Goodbye!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                userInputReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } //end try catch

            if (socketWriter != null) {
                try {
                    socketWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } //end try catch
            } //end if

            if (socketReader != null) {
                try {
                    socketReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } //end try catch
            } //end if
        } //end try catch finally
    } //main
}
