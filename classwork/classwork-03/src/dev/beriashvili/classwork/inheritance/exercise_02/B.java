package dev.beriashvili.classwork.inheritance.exercise_02;

public class B extends A {
    B(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getDifference() {
        return y - x;
    }

    int getSum() {
        return x + y * 2;
    }
}
