package dev.beriashvili.classwork.inheritance.exercise_01;

public class Main {
    public void main() {
        A a = new A();
        a.setData();
        a.printValue(A.x);
        System.out.println(a.isEvenOrOdd(A.x));

        B b = new B();
        b.setData();
        System.out.println(String.format("%d + %d = %d", A.x, b.y, b.getSum()));
    }
}
