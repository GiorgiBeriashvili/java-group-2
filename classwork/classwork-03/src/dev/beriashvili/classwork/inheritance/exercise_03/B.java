package dev.beriashvili.classwork.inheritance.exercise_03;

public class B extends A {
    int methodOne() {
        return (y - x) / 3;
    }

    int methodTwo() {
        return ((int) Math.pow(x, 2) + 2 * y) / 5;
    }

    void printX() {
        System.out.println(String.format("The value of x is: %d", x));
    }
}
