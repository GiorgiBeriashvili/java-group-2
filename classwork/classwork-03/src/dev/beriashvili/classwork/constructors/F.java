package dev.beriashvili.classwork.constructors;

public class F {
    float x, y;

    F() {

    }

    public F(int x) {
        this.x = x;
    }

    public F(int x, int y) {
        this.x = x;
        this.y = y;
    }

    float getGCD(float x, float y) {
        return y == 0 ? x : getGCD(y, x % y);
    }
}
