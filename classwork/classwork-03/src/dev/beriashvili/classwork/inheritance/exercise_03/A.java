package dev.beriashvili.classwork.inheritance.exercise_03;

import java.util.Random;
import java.util.Scanner;

public class A {
    static int x, y;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        x = scanner.nextInt();

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();
    }

    void setRandomData() {
        Random random = new Random();

        x = random.nextInt(67) + 12;
        y = random.nextInt(67) + 12;
    }

    void printY() {
        System.out.println(String.format("The value of y is: %d", y));
    }
}
