import java.io.*;
import java.net.*;

/*
 * Copyright (c) 2025 nocku
 * Licensed under the MIT License. See LICENSE in project root for details.
 */

public class Receive {
    public static void main(String[] args) throws IOException {
        System.out.println("Quiq receive v/a-0.1");
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
            System.out.println("Client: " + line);
            out.println("Server received: " + line);
        }

    }
}