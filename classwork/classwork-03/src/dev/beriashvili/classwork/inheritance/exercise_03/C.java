package dev.beriashvili.classwork.inheritance.exercise_03;

public class C extends B {
    double z, r;

    double getMaximum() {
        double[] array = {x, y, z, r};
        double maximum = array[0];

        System.out.println(array.length);

        for (int index = 1; index < array.length; index++) {
            if (array[index] > maximum) {
                maximum = array[index];
            }
        }

        return maximum;
    }

    double methodThree() {
        return ((int) Math.pow(x, 2) + 2 * y) / (z - r);
    }

    double methodFour() {
        return methodOne() + r / (z + 4);
    }
}
