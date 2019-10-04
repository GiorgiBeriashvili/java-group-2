package dev.beriashvili.classwork.inheritance.exercise_02;

public class Main {
    public void main() {
        A a = new A();
        a.setData();
        a.printX();
        a.printY();

        B b = new B(a.x, a.y);
        System.out.println(String.format("%d - %d = %d", b.y, b.x, b.getDifference()));
        System.out.println(String.format("%d + 2 * %d = %d", b.x, b.y, b.getSum()));

        C c = new C(b.x, b.y);
        System.out.println(String.format("The arithmetic mean of (%d, %d, %f) is: %f", c.x, c.y, c.z, c.getArithmeticMean()));
        System.out.println(String.format("The geometric mean of (%d, %d, %f) is: %f", c.x, c.y, c.z, c.getGeometricMean()));
        System.out.println(String.format("The maximum of (%d, %d, %f) is: %f", c.x, c.y, c.z, c.getMaximum()));
    }
}
