package dev.beriashvili.classwork.Project4;

import java.util.Scanner;

public class A {
    private int x, y, z;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        x = scanner.nextInt();

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();

        System.out.print("Enter the value of z: ");
        z = scanner.nextInt();
    }

    int methodOne() {
        return 2 * x - 7;
    }

    int methodTwo() {
        return 3 * y + z;
    }

    int methodThree() {
        return 12 * y - x + z;
    }
}
