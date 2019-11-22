package dev.beriashvili.practice.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private int connectionCount = 0;

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = new Socket(InetAddress.getByName("localhost"), 8888);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                System.out.print("Enter the message: ");
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();

                // Send
                objectOutputStream.writeObject(message);

                // Get
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = objectInputStream.readObject().toString();

                System.out.println(String.format("Server: %s", message));

                if (connectionCount != 4) {
                    connectionCount++;
                } else {
                    System.out.println("Closing the program...");
                    System.exit(0);
                }
            }
        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }
}
