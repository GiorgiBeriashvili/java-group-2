package dev.beriashvili.classwork.inheritance.exercise_04;

import java.util.Random;
import java.util.Scanner;

public class B extends A {
    private double a, b;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();
    }

    void methodTwo() {
        if (a > b) {
            double temporary;

            temporary = a;
            a = b;
            b = temporary;
        }
    }

    void methodThree() {
        Random random = new Random();

        x = (double) random.nextInt((int) (b - a + 1)) + a;
    }
}
