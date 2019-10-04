package dev.beriashvili.classwork.inheritance.exercise_01;

import java.util.Scanner;

public class A {
    static int x;

    A() {
        System.out.println("hello My A Class");
    }

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        x = scanner.nextInt();
    }

    void printValue(int value) {
        System.out.println(String.format("x = %d", value));
    }

    String isEvenOrOdd(int value) {
        if ((value & 1) == 0) {
            return String.format("%d is an even number.", value);
        } else {
            return String.format("%d is an odd number.", value);
        }
    }
}
