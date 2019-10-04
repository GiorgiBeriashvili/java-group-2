package dev.beriashvili.classwork.constructors;

import java.util.Arrays;

public class Main {
    public void main() {
        A a = new A();
        System.out.println(a.isEvenOrOdd());

        B b = new B();
        System.out.println(String.format("It is %b that %d is in the range of [5, 24].", b.inRange(), b.x));
        b = new B(5);
        System.out.println(String.format("It is %b that %d is in the range of [5, 24].", b.inRange(), b.x));

        C c = new C();
        System.out.println(String.format("The interval created from %d and %d is: %s", c.a, c.b, Arrays.toString(c.getInterval())));
        System.out.println(String.format("It is %b that %d is in the interval of %s.", c.inInterval(), c.x, Arrays.toString(c.getInterval())));

        D d = new D();
        System.out.println(String.format("(4 * x - y if x > 0, 2 * x + y if x <= 0) = %d (x = %d, y = %d)", d.methodOne(), d.x, d.y));
        System.out.println(String.format("(4 * x + y if x > 0, 2 * x - y if x <= 0) = %d (x = %d, y = %d)", d.methodTwo(), d.x, d.y));

        E e = new E();
        System.out.println(String.format("x / y + xy if y != 0, x^4 + y if x <= 0 = %f (x = %f, y = %f)", e.methodOne(), e.x, e.y));
        System.out.println(String.format("The minimum of (%f, %f) is: %f", e.x, e.y, e.methodTwo()));

        F f = new F();
        System.out.println(String.format("The greatest common divisor of (%f, %f) is: %f", f.x, f.y, f.getGCD(f.x, f.y)));
    }
}
