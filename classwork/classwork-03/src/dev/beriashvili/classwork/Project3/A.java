package dev.beriashvili.classwork.Project3;

import java.util.Random;
import java.util.Scanner;

public class A {
    int[] m = new int[10];

    public void setData() {
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < m.length; index++) {
            System.out.print(String.format("Enter the value for the array's #%d index: ", index));
            m[index] = scanner.nextInt();
        }
    }

    void setRandomData() {
        Random random = new Random();

        for (int index = 0; index < m.length; index++) {
            m[index] = random.nextInt(16);
        }
    }

    int getSum() {
        int sum = 0;

        for (int index = 0; index < m.length; index++) {
            if (m[index] < index) {
                sum += m[index];
            }
        }

        return sum;
    }

    int getProduct() {
        int product = 1;

        for (int index = 0; index < m.length; index++) {
            if (m[index] > index) {
                product *= m[index];
            }
        }

        return product;
    }
}
