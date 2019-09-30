package dev.beriashvili.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class RandomRange {
    /*
		3. შეიტანეთ a და b მთელი რიცხვები, გამოიტანეთ [a; b] შუალედიდან 40
		შემთხვევითი რიცხვი (თუ a მეტია b-ზე, ამ ორი ცვლადის მნიშვნელობას გაუცვა-
		ლეთ ადგილები). დაადგინეთ რამდენი ლუწი და რამდენი კენტი რიცხვია
		გამოტანილ რიცხვებს შორის, გამოიტანეთ ლუწი და კენტი რიცხვების ჯამი, მიღე-
		ბულ ჯამებს შორის გამოიტანეთ 5 შემთხვევითი რიცხვი.
     */

    private int a;
    private int b;

    private void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();
    }

    private int[] getRandomIntegers(int length, int min, int max) {
        int[] randomIntegers = new int[length];
        Random random = new Random();

        for (int index = 0; index < randomIntegers.length; index++) {
            int randomInteger = random.nextInt(max - min + 1) + min;
            randomIntegers[index] = randomInteger;
        }

        return randomIntegers;
    }

    private int getParityCount(int[] array, int parity) {
        int count = 0;

        for (int element : array) {
            if ((element & 1) == parity) {
                count++;
            }
        }

        return count;
    }

    private int getEvenIntCount(int[] array) {
        return getParityCount(array, 0);
    }

    private int getOddIntCount(int[] array) {
        return getParityCount(array, 1);
    }

    private void printParityCount(String parity, int parityCount) {
        System.out.println(String.format("There are a total amount of %d %s numbers in the range.", parityCount, parity));
    }

    private int getParitySum(int[] array, int parity) {
        int sum = 0;

        for (int element : array) {
            if ((element & 1) == parity) {
                sum += element;
            }
        }

        return sum;
    }

    private int getEvenIntSum(int[] array) {
        return getParitySum(array, 0);
    }

    private int getOddIntSum(int[] array) {
        return getParitySum(array, 1);
    }

    private void printParitySum(String parity, int paritySum) {
        System.out.println(String.format("The sum of the %s numbers in the range is: %d", parity, paritySum));
    }

    void main() {
        setData();

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int[] fortyRandomIntegers = getRandomIntegers(40, min, max);

        System.out.println(String.format("Forty random integers: %s", Arrays.toString(fortyRandomIntegers)));

        printParityCount("even", getEvenIntCount(fortyRandomIntegers));
        printParityCount("odd", getOddIntCount(fortyRandomIntegers));

        int evenIntSum = getEvenIntSum(fortyRandomIntegers), oddIntSum = getOddIntSum(fortyRandomIntegers);

        printParitySum("even", evenIntSum);
        printParitySum("odd", oddIntSum);

        min = Math.min(evenIntSum, oddIntSum);
        max = Math.max(evenIntSum, oddIntSum);
        int[] fiveRandomIntegers = getRandomIntegers(5, min, max);

        System.out.println(String.format("Five random integers: %s", Arrays.toString(fiveRandomIntegers)));
    }
}
