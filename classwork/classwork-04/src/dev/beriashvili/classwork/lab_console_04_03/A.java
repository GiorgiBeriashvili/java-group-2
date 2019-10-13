package dev.beriashvili.classwork.lab_console_04_03;

import java.util.ArrayList;

public class A implements Interface {
    /*
     * განსაზღვრეთ კლასი A: ორი მთელი ტიპის a და b თვისებით.
     * */
    int a, b;

    /*
     * ბეჭდავს ყველა მთელ რიცხვს a-სა და b-ს შორის;
     * */
    @Override
    public void printIntegersBetweenTwoValues() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int minimum = Math.min(this.a, this.b), maximum = Math.max(this.a, this.b);

        for (; minimum <= maximum; minimum++) {
            integerArrayList.add(minimum);
        }

        System.out.println(String.format("Integers between a (%d) and b (%d): %s", this.a, this.b, integerArrayList.toString()));
    }

    /*
     * ბეჭდავს a-ს ყველა გამყოფს;
     * */
    @Override
    public void printDivisorsOfA() {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int index = 1; index <= this.a; index++) {
            if (this.a % index == 0) {
                divisors.add(index);
            }
        }

        System.out.println(String.format("Divisors of a (%d): %s", this.a, divisors.toString()));
    }

    /*
     * ბეჭდავს b-ს ყველა მარტივ გამყოფს;
     * */
    @Override
    public void printPrimeDivisorsOfB() {
        ArrayList<Integer> divisors = new ArrayList<>();
        ArrayList<Integer> primeDivisors = new ArrayList<>();

        for (int index = 1; index <= this.a; index++) {
            if (this.a % index == 0) {
                divisors.add(index);
            }
        }

        for (Integer divisor : divisors) {
            boolean isPrime = true;

            for (int integer = 2; integer < divisor; integer++) {
                if (divisor % integer == 0) {
                    isPrime = false;

                    break;
                }
            }

            if (divisor > 1 & isPrime) {
                primeDivisors.add(divisor);
            }
        }

        System.out.println(String.format("Prime divisors of a (%d): %s", this.a, primeDivisors.toString()));
    }

    /*
     * აბრუნებს b-ს ჩანაწერში ყველაზე ხშირად გამეორებად ციფრს.
     * */
    @Override
    public int getTheMostFrequentDigitOfB() {
        int integer = this.b;
        int[] frequencies = new int[10];
        int maximumFrequency = Integer.MIN_VALUE;
        int theMostFrequentDigit = 0;

        while (integer > 0) {
            int digit = integer % 10;
            integer /= 10;

            frequencies[digit]++;
        }

        for (int index = 0; index < frequencies.length; index++) {
            if (frequencies[index] > maximumFrequency) {
                maximumFrequency = frequencies[index];
                theMostFrequentDigit = index;
            }
        }

        return theMostFrequentDigit;
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printThreeRandomIntegersBetweenTwoValues() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printThreeMultiplesOfA() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printEveryIntegerCreatedFromTheDigitsOfB() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public int getMaximumDigitOfB() {
        return 0;
    }
}
