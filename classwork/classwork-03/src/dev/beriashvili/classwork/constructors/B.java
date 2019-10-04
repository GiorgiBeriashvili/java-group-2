package dev.beriashvili.classwork.constructors;

class B {
    int x;

    B() {
    }

    B(int x) {
        this.x = x;
    }

    boolean inRange() {
        return x >= 5 && x <= 24;
    }
}
