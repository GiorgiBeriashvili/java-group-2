package dev.beriashvili.classwork.inheritance.exercise_03;

public class Main {
    public void main() {
        A a = new A();
        a.setData();
        a.setRandomData();
        a.printY();

        B b = new B();
        System.out.println(String.format("(%d - %d) / 3 = %d", A.y, A.x, b.methodOne()));
        System.out.println(String.format("(%d + %d) / 5 = %d", (int) Math.pow(A.x, 2), 2 * A.y, b.methodTwo()));
        b.printX();

        C c = new C();
        System.out.println(String.format("The maximum of (%d, %d, %f, %f) is: %f", A.x, A.y, c.z, c.r, c.getMaximum()));
        System.out.println(String.format("(%d + %d) * (%f - %f) = %f", (int) Math.pow(A.x, 2), 3 * A.y, c.z, c.r, c.methodThree()));
        System.out.println(String.format("%d + %f / (%f + 4) = %f", c.methodOne(), c.r, c.z, c.methodFour()));
    }
}
