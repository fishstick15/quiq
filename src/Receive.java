import java.io.*;
import java.net.*;

/*
 * Copyright (c) 2025 nocku
 * Licensed under the MIT License. See LICENSE in project root for details.
 */

public class Receive {
    public static void main(String[] args) throws Exception {
        System.out.println("Quiq receive 0.1.0-alpha");
        System.out.println("Copyright (c) 2025 nocku");
        System.out.println("\n");
        int port = 5000;

        ServerSocket receiveSocket = new ServerSocket(port);
        Socket sendSocket = receiveSocket.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(sendSocket.getInputStream())
        );

        PrintWriter out = new PrintWriter(sendSocket.getOutputStream(), true);

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            out.println("Server (" + getUserIp() + ") received: " + line);
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