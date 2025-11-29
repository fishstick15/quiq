import java.io.*;
import java.net.*;

/*
 * Copyright (c) 2025 nocku
 * Licensed under the MIT License. See LICENSE in project root for details.
 */

public class Receive {

    public static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";


    public static void main(String[] args) throws Exception {
        System.out.println("Quiq send 0.1.0-alpha");
        System.out.println(BOLD + "Copyright (c) 2025 nocku" + RESET);
        System.out.println("\n");
        int port = 5000;

        ServerSocket receiveSocket = new ServerSocket(port);
        System.out.println("Socket request created..");
        Socket sendSocket = receiveSocket.accept();

        InetAddress otherIP = receiveSocket.getInetAddress();

        System.out.println("Socket request accepted by " + otherIP.getHostAddress());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(sendSocket.getInputStream())
        );


        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
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