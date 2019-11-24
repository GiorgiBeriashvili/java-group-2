package dev.beriashvili.classwork.networking.consultant;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            FileHandler fileHandler = new FileHandler();

            String[] commands = {"help", "date", "name", "error"};

            //noinspection InfiniteLoopStatement
            while (true) {
                fileHandler.generateData();
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String message = objectInputStream.readObject().toString();

                // Get the client's input
                System.out.println(String.format("Client: %s", message));

                // Parse the informative file's content to match the client's input to a valid command
                if (Arrays.asList(commands).contains(message.trim().toLowerCase())) {
                    message = fileHandler.getData(message.trim().toLowerCase());
                } else {
                    message = "Invalid command. Please enter either one of - \"help, date, name, error\"";
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
