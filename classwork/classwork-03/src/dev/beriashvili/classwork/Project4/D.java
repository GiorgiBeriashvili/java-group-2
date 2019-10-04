package dev.beriashvili.classwork.Project4;

import java.util.Scanner;

public class D {
    private double a, b, z;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();

        System.out.print("Enter the value of z: ");
        z = scanner.nextInt();
    }

    double methodOne() {
        return (a + Math.pow(b, 3) - 7) / (z + 8);
    }

    double methodTwo() {
        return (a + z - Math.pow(b, 3)) / (z * a * b);
    }

    double methodThree() {
        return (a * z - b) / (z * b);
    }
}
