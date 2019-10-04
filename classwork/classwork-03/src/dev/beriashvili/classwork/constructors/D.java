package dev.beriashvili.classwork.constructors;

class D {
    int x, y;

    D() {
        System.out.println("hello My Class");
    }

    int methodOne() {
        return x > 0 ? 4 * x - y : 2 * x + y;
    }

    int methodTwo() {
        return x > 0 ? 4 * x + y : 2 * x - y;
    }
}
