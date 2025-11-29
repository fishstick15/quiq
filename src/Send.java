import java.io.*;
import java.net.*;

/*
 * Copyright (c) 2025 nocku
 * Licensed under the MIT License. See LICENSE in project root for details.
 */

public class Send {
    public static void main(String[] args) throws Exception {
        System.out.println("Quiq send 0.1.0-alpha");
        System.out.println("Copyright (c) 2025 nocku");
        System.out.println("\n");
        String serverIP;
        int port = 5000;

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter ip to connect to: ");
        serverIP = userInput.readLine();

        Socket socket = new Socket(serverIP, port);



        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            System.out.println("Enter message: ");
            String input = userInput.readLine();

            if (input == null || input.equalsIgnoreCase("quit")) break;

            out.println(getUserIp() + ": " + input);
            System.out.println("Server replied: " + in.readLine());

        }
    }

    public static String getUserIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader ipin = null;
        try {
            ipin = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = ipin.readLine();
            return ip;

        } finally {
            if (ipin != null) {
                try {
                    ipin.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
