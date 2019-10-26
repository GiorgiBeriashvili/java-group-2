package dev.beriashvili.practice;

import dev.beriashvili.practice.thread.ThreadRunnable;

public class Main {
    public static void main(String[] args) {
        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread thread = new Thread(threadRunnable);
        thread.start();

        System.out.println("Main has finished!");
    }
}
