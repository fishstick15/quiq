import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

/*
 * Copyright (c) 2025 nocku
 * Licensed under the MIT License. See LICENSE in project root for details.
 */

public class SendReceive {

    public static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws Exception {
        System.out.println("Quiq 0.3.0-alpha");
        System.out.println(BOLD + "Copyright (c) 2025 nocku" + RESET);
        System.out.println("\n");
        String serverIP;
        int port = 5000;

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Would you like to connect to a socket or host a socket? [host] [join]");
        String socketChoiceuserInput = userInput.readLine();
        if (socketChoiceuserInput.equalsIgnoreCase("host")) {

            // create socket
            System.out.println("Creating new socket on your ip (" + getUserIp() + ")");
            ServerSocket receiveSocket = new ServerSocket(port);
            System.out.println("Socket created.");

            // wait for connection & display connetion IP
            Socket sendSocket = receiveSocket.accept();
            InetAddress otherIP = receiveSocket.getInetAddress();
            System.out.println("Socket request accepted by " + otherIP.getHostAddress());

            // create input bufferReader
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(sendSocket.getInputStream())
            );

            // print input
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }


        } else if (socketChoiceuserInput.equalsIgnoreCase("join")) {
            System.out.println("Enter ip to connect to: ");
            serverIP = userInput.readLine();

            System.out.println("Searching for socket request on " + serverIP + "..");
            Socket socket = null;
            try {
                socket = new Socket(serverIP, port);
            } catch (Exception e) {
                System.out.println("No socket request found on " + serverIP);
                System.out.println("Closing automatically in 5 seconds.");
                Thread.sleep(5000);
                System.out.println("Exiting..");
                System.exit(0);
            }

            System.out.println("Socket request found and accepted!");


            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            while (true) {
                System.out.println("Enter message: ");
                String input = userInput.readLine();

                if (input == null || input.equalsIgnoreCase("quit")) break;

                out.println("[" + getTimeDate() + "] " + getUserIp() + ": " + input);

            }
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

    public static String getTimeDate() {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        String date = ft.format(new Date());

        LocalTime time = LocalTime.now();

        return time + " " + date;
    }
}
