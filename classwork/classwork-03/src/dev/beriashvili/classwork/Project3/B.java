package dev.beriashvili.classwork.Project3;

import java.util.Random;
import java.util.Scanner;

public class B {
    double[] m = new double[12];

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < m.length; index++) {
            System.out.print(String.format("Enter the value for the array's #%d index: ", index));
            m[index] = scanner.nextDouble();
        }
    }

    void setRandomData() {
        Random random = new Random();

        for (int index = 0; index < m.length; index++) {
            m[index] = random.nextInt(16);
        }
    }

    void printValuesGreaterThanSeven() {
        for (int index = 0; index < m.length; index++) {
            if (m[index] > 7) {
                System.out.println(String.format("The value %f of the array's #%d index.", m[index], index));
            }
        }
    }

    double getRange() {
        double minimum = Double.MAX_VALUE, maximum = Double.MIN_VALUE;

        for (double element : m) {
            if (element < minimum) {
                minimum = element;
            }

            if (element > maximum) {
                maximum = element;
            }
        }

        return maximum - minimum;
    }
}
