package dev.beriashvili.practice;

import dev.beriashvili.practice.networking.Client;
import dev.beriashvili.practice.networking.Server;

public class Main {
    public static void main(String[] args) {
        Thread serverThread = new Thread(new Server());
        serverThread.start();

        Thread clientThread = new Thread(new Client());
        clientThread.start();
    }
}
