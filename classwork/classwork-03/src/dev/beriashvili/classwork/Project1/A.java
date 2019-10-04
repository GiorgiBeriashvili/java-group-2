package dev.beriashvili.classwork.Project1;

import java.util.Scanner;

public class A {
    public int a, b;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();
    }

    void printSum() {
        System.out.println(String.format("%d + %d = %d", a, b, a + b));
    }

    int getProduct() {
        return a * b;
    }
}
