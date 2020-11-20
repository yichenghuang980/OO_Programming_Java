package HW1;

import java.io.IOException;

/**
 * A server used to obtain the years, months, and days until a date requested by a client.
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- Network I/O -- Homework</p>
 *
 * @author Purdue CS
 * @version April 6, 2020
 */
public final class CountdownRunner {
    /**
     * Creates a {@code CountdownServer} instance, then begins to serve clients.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountdownServer server;

        try {
            server = new CountdownServer();
        } catch (IOException e) {
            e.printStackTrace();

            return;
        } //end try catch

        server.serveClients();
    } //main
}
