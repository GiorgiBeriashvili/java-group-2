package dev.beriashvili.classwork.Project4;

public class Main {
    public void main() {
        A a = new A();
        a.setData();
        System.out.println(String.format("2x - 7 = %d", a.methodOne()));
        System.out.println(String.format("3y + z = %d", a.methodTwo()));
        System.out.println(String.format("12y - x + z = %d", a.methodThree()));

        B b = new B();
        b.setData();
        System.out.println(String.format("2n^2 + 1 = %d", b.methodOne()));
        System.out.println(String.format("3y^2 - n^2 = %d", b.methodTwo()));

        C c = new C();
        c.setData();
        System.out.println(String.format("4a^2 / b - 1 = %f", c.methodOne()));
        System.out.println(String.format("3(a^2 / 2) - b^2 = %f", c.methodTwo()));

        D d = new D();
        d.setData();
        System.out.println(String.format("(a + b^3 - 7) / (z + 8) = %f", d.methodOne()));
        System.out.println(String.format("(a + z - b^3) / (zab) = %f", d.methodTwo()));
        System.out.println(String.format("(az - b) / (zb) = %f", d.methodThree()));
    }
}
