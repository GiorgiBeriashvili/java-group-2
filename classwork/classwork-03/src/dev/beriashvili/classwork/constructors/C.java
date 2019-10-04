package dev.beriashvili.classwork.constructors;

public class C {
    int a, b, x;

    C() {
    }

    public C(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int[] getInterval() {
        return new int[]{a, b};
    }

    boolean inInterval() {
        int[] range = getInterval();

        int minimum = Math.min(range[0], range[1]);
        int maximum = Math.max(range[0], range[1]);

        return x >= minimum && x <= maximum;
    }
}
