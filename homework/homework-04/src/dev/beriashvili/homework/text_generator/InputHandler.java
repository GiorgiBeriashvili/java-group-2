package dev.beriashvili.homework.text_generator;

import java.util.Scanner;

public class InputHandler implements Input {
    final Scanner scanner = new Scanner(System.in);

    @Override
    public String getLanguage() {
        System.out.print("Enter the desired language: ");

        return scanner.nextLine();
    }

    @Override
    public String getParameters() {
        System.out.print("Enter the desired parameters: ");

        return scanner.nextLine();
    }
}
