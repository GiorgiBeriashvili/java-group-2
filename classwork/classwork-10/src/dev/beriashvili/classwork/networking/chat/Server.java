package dev.beriashvili.classwork.networking.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String message = objectInputStream.readObject().toString();

                // Get the client's input
                System.out.println(String.format("Client: %s", message));

                System.out.print("Server: ");

                // Get the server's input
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();

                // Exit out of the session
                if (message.equals(":close") | message.equals(":exit") | message.equals(":quit")) {
                    System.out.println("\nClosing the program...");
                    System.exit(0);
                }

                // Send the server's input to the client
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message);
            }
        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }
}
