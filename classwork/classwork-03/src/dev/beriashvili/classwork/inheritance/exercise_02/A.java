package dev.beriashvili.classwork.inheritance.exercise_02;

import java.util.Scanner;

public class A {
    int x, y;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        x = scanner.nextInt();

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();
    }

    void printX() {
        System.out.println(String.format("The value of x is: %d", x));
    }

    void printY() {
        System.out.println(String.format("The value of y is: %d", y));
    }
}
