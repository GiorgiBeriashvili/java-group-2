package dev.beriashvili.classwork.Project1;

import java.util.Scanner;

public class B {
    int a, b, c;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();

        System.out.print("Enter the value of c: ");
        c = scanner.nextInt();
    }

    void printMaximum() {
        System.out.println(String.format("Maximum of (%d, %d, %d) is: %d", a, b, c, Math.max(a, Math.max(b, c))));
    }

    public int getMinimum() {
        return Math.min(a, Math.min(b, c));
    }
}
