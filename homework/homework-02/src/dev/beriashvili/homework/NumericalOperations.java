package dev.beriashvili.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class NumericalOperations implements Operations {
    /*
     * 3. განსაზღვრეთ კლასი : ორი მთელი ტიპის a და b ცვლადით, კლასისთვის გამოიყენეთ
     *    ინტერფეისი.
     *    მეთოდი 1: ბეჭდავს ყველა მთელ რიცხვს a-სა და b-ს შორის;
     *    მეთოდი 2: ბეჭდავს a-ს ყველა გამყოფს;
     *    მეთოდი 3: ბეჭდავს b-ს ყველა მარტივ გამყოფს;
     *    მეთოდი 4: აბრუნებს b-ს ჩანაწერში ყველაზე ხშირად გამეორებად ციფრს.
     *    Main მეთოდში მოახდინეთ თვისებებისთვის მნიშვნელობების მინიჭებისა და მათი
     *    გამოყენების მაგალითებით დემონსტრირება.
     * */
    private int a, b;

    NumericalOperations() {
        this.a = -10;
        this.b = 10;
    }

    NumericalOperations(int threshold) {
        this.a = -threshold;
        this.b = threshold;
    }

    NumericalOperations(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void main() {
        printIntegersFromInterval(this.a, this.b);
        printDivisors(this.a);
        printPrimeDivisors(this.b);
        System.out.println(getMostFrequentDigit(this.b));
    }

    @Override
    public void printIntegersFromInterval(int start, int end) {
        int minimumBound = Math.min(start, end);
        int maximumBound = Math.max(start, end);

        int[] integers = new int[maximumBound - minimumBound + 1];

        for (int index = 0, integer = minimumBound; integer <= maximumBound; index++, integer++) {
            integers[index] = integer;
        }

        System.out.println(String.format("Integers between %d and %d: %s", minimumBound, maximumBound, Arrays.toString(integers)));
    }

    @Override
    public void printDivisors(int integer) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int index = 1; index <= integer; index++) {
            if (integer % index == 0) {
                divisors.add(index);
            }
        }

        System.out.println(String.format("Divisors of a (%d): %s", integer, divisors.toString()));
    }

    @Override
    public void printPrimeDivisors(int integer) {
        ArrayList<Integer> divisors = new ArrayList<>();
        ArrayList<Integer> primeDivisors = new ArrayList<>();

        for (int index = 1; index <= integer; index++) {
            if (integer % index == 0) {
                divisors.add(index);
            }
        }

        for (Integer divisor : divisors) {
            boolean isPrime = true;

            for (int element = 2; element < divisor; element++) {
                if (divisor % element == 0) {
                    isPrime = false;

                    break;
                }
            }

            if (divisor > 1 & isPrime) {
                primeDivisors.add(divisor);
            }
        }

        System.out.println(String.format("Prime divisors of b (%d): %s", integer, primeDivisors.toString()));
    }

    @Override
    public String getMostFrequentDigit(int integer) {
        int[] frequencies = new int[10];

        int maximumFrequency = Integer.MIN_VALUE;
        int theMostFrequentDigit = 0;

        int preservedInteger = integer;

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

        ArrayList<Integer> maxima = new ArrayList<>();

        int frequencyCount = 0;

        for (int index = 0; index < frequencies.length; index++) {
            if (frequencies[index] == maximumFrequency) {
                maxima.add(index);

                frequencyCount++;
            }
        }

        if (frequencyCount > 1) {
            return String.format("The most frequent digits of the integer %d are: %s.", preservedInteger, maxima.toString());
        } else {
            return String.format("The most frequent digit of b (%d) is: %d", preservedInteger, theMostFrequentDigit);
        }
    }
}
