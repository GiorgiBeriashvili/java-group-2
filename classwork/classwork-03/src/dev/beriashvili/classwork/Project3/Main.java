package dev.beriashvili.classwork.Project3;

import java.util.Arrays;

public class Main {
    public void main() {
        A a = new A();
        a.setData();
        a.setRandomData();
        System.out.println(String.format("The array with randomized elements: %s", Arrays.toString(a.m)));
        System.out.println(String.format("The sum of all of the array's elements less than their corresponding index's value is: %d", a.getSum()));
        System.out.println(String.format("The product of all of the array's elements greater than their corresponding index's value is: %d", a.getProduct()));

        B b = new B();
        b.setData();
        b.setRandomData();
        System.out.println(String.format("The array with randomized elements: %s", Arrays.toString(b.m)));
        b.printValuesGreaterThanSeven();
        System.out.println(String.format("The range of the array's largest and smallest elements is: %f", b.getRange()));
    }
}
