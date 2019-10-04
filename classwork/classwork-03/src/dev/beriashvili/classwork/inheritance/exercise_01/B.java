package dev.beriashvili.classwork.inheritance.exercise_01;

import java.util.Scanner;

public class B extends A {
    int y;

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();
    }

    int getSum() {
        return x + y;
    }
}
