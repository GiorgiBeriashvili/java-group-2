package dev.beriashvili.classwork.constructors;

public class E {
    float x, y;

    E() {
    }

    public E(int x) {
        this.x = x;
    }

    float methodOne() {
        if (y != 0) {
            return x / y + x * y;
        } else if (x <= 0) {
            return (float) Math.pow(x, 4) + y;
        } else {
            return 0;
        }
    }

    float methodTwo() {
        return Math.min(x, y);
    }
}
