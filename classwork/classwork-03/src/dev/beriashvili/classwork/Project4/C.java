package dev.beriashvili.classwork.Project4;

import java.util.Scanner;

public class C {
    private double a, b;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();
    }

    double methodOne() {
        return (4 * Math.pow(a, 2)) / b - 1;
    }

    double methodTwo() {
        return 3 * (Math.pow(a, 3) / 2) - Math.pow(b, 2);
    }
}
