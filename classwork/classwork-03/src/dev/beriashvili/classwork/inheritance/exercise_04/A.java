package dev.beriashvili.classwork.inheritance.exercise_04;

import java.util.Random;
import java.util.Scanner;

public class A {
    double x;
    private double y;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        x = scanner.nextInt();

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();
    }

    void setRandomData() {
        Random random = new Random();

        x = random.nextInt(13);
        y = random.nextInt(13);
    }

    void methodOne() {
        System.out.println(String.format("(%f - 3 * %f) / 3 = %f", y, x, (y - 3 * x) / 3));
    }
}
