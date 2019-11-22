package dev.beriashvili.practice.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String message = objectInputStream.readObject().toString();

                // Get
                System.out.println(String.format("Client: %s", message));

                if (message.equals("Goodbye!")) {
                    System.out.println("\nClosing the program...");
                    System.exit(0);
                }

                // Send
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(String.format("Successfully read \"%s\"!\n", message));
            }
        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }
}
