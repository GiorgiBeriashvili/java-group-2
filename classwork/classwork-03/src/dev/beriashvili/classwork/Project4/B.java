package dev.beriashvili.classwork.Project4;

import java.util.Scanner;

public class B {
    private int n, y;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        n = scanner.nextInt();

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();
    }

    int methodOne() {
        return 2 * (int) Math.pow(n, 2) + 1;
    }

    int methodTwo() {
        return 3 * (int) Math.pow(y, 3) - (int) Math.pow(n, 2);
    }
}
