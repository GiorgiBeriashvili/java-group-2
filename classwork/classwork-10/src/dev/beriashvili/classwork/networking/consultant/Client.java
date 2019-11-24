package dev.beriashvili.classwork.networking.consultant;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    @Override
    public void run() {
        try {
            boolean initialMessage = true;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                Socket socket = new Socket(InetAddress.getLocalHost(), 8081);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                if (initialMessage) {
                    System.out.println("Consult with the server!");
                    System.out.println("To exit out of the session, type in either one of: \":close\", \":exit\", \":quit\"!\n");

                    initialMessage = false;
                }

                // Get the client's input
                System.out.print("> ");
                String message = scanner.nextLine();

                // Exit out of the session
                if (message.equals(":close") | message.equals(":exit") | message.equals(":quit")) {
                    System.out.println("\nExiting out of the session...");

                    System.exit(0);
                }

                // Send the client's input to the server
                objectOutputStream.writeObject(message);

                // Get the server's input and display it on the console
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = objectInputStream.readObject().toString();

                System.out.println(String.format("Server: %s", message));
            }
        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }
}
