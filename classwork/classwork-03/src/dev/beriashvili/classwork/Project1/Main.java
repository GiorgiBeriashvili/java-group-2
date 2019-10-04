package dev.beriashvili.classwork.Project1;

public class Main {
    public void main() {
        A a = new A();
        a.setData();
        a.printSum();
        System.out.println(String.format("%d * %d = %d", a.a, a.b, a.getProduct()));

        B b = new B();
        b.setData();
        b.printMaximum();
        System.out.println(String.format("Minimum of (%d, %d, %d) is: %d", b.a, b.b, b.c, Math.min(b.a, Math.min(b.b, b.c))));

        C c = new C();
        c.setData();
        System.out.println(String.format("Last digit of %d is: %d", c.a, c.getLastDigit()));
        System.out.println(String.format("First digit of %d is: %d", c.b, c.getFirstDigit()));
        System.out.println(String.format("Digit sum of %d is: %d", c.c, c.getDigitSum()));
        c.printProduct();
        c.printSum();
    }
}
