package dev.beriashvili.classwork.constructors;

class A {
    private int x;

    A() {
        System.out.println("hello My Class");
    }

    String isEvenOrOdd() {
        if ((x & 1) == 0) {
            return String.format("%d is even.", x);
        } else {
            return String.format("%d is odd.", x);
        }
    }
}
