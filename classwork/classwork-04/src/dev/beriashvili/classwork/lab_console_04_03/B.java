package dev.beriashvili.classwork.lab_console_04_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class B implements Interface {
    /*
     * განსაზღვრეთ კლასი B: ორი მთელი ტიპის ცვლადით a და b; ორი თვისებებით _a და
     * _b.
     * */
    private int a, b;

    /*
     * თვისება _a: ახდენს a ცვლადის ინიციალიზაციას, a ცვლადს ანიჭებს მხოლოდ
     * დადებით მნიშვნელობას;
     * */
    void _a(int minimumBound, int maximumBound) {
        Random random = new Random();

        if (maximumBound == Integer.MAX_VALUE) {
            this.a = Math.abs(random.nextInt(maximumBound) - minimumBound);
        } else {
            this.a = Math.abs(random.nextInt(maximumBound - minimumBound) + minimumBound);
        }
    }

    /*
     * თვისება _b: ახდენს b ცვლადის ინიციალიზაციას, b ცვლადს ანიჭებს მხოლოდ
     * სამნიშნა დადებით მნიშვნელობას;
     * */
    void _b(int minimumBound, int maximumBound) {
        if (minimumBound < 100 || minimumBound > 999) {
            minimumBound = 100;
        }

        if (maximumBound < 100 || maximumBound > 999) {
            maximumBound = 999;
        }

        Random random = new Random();

        this.b = Math.abs(random.nextInt(maximumBound + 1) - minimumBound);
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printIntegersBetweenTwoValues() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printDivisorsOfA() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printPrimeDivisorsOfB() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public int getTheMostFrequentDigitOfB() {
        return 0;
    }

    /*
     * ბეჭდავს სამ შემთხვევით რიცხვს a-სა და b-ს შორის;
     * */
    @Override
    public void printThreeRandomIntegersBetweenTwoValues() {
        int minimum = Math.min(this.a, this.b), maximum = Math.max(this.a, this.b);
        int[] randomIntegers = new int[3];

        Random random = new Random();

        for (int index = 0; index < 3; index++) {
            randomIntegers[index] = random.nextInt(maximum - minimum) + minimum;
        }

        System.out.println(String.format("Three random integers between a (%d) and b (%d) are: %s", this.a, this.b, Arrays.toString(randomIntegers)));
    }

    /*
     * ბეჭდავს a-ს სამ ჯერად რიცხვს;
     * */
    @Override
    public void printThreeMultiplesOfA() {
        int[] multiples = new int[3];

        Random random = new Random();

        for (int index = 0; index < 3; index++) {
            boolean isMultiple = false;

            while (!isMultiple) {
                int randomMultiple = random.nextInt(Integer.MAX_VALUE - this.a) + this.a;

                if (randomMultiple % this.a == 0) {
                    multiples[index] = this.a * (randomMultiple / this.a);

                    isMultiple = true;
                }
            }
        }

        System.out.println(String.format("Three (random) multiple of a (%d) are: %s", this.a, Arrays.toString(multiples)));
    }

    /*
     * ბეჭდავს b-ს ციფრებით შედგენილ ყველა შესაძლო რიცხვებს;
     * */
    @Override
    public void printEveryIntegerCreatedFromTheDigitsOfB() {
        String string = Integer.toString(this.b);

        int[] integerArray = new int[string.length()];

        for (int index = 0; index < string.length(); index++) {
            integerArray[index] = string.charAt(index) - '0';
        }

        List<List<Integer>> permutationsList = new ArrayList<>();
        permutationsList.add(new ArrayList<>());

        for (int integer : integerArray) {
            List<List<Integer>> current = new ArrayList<>();

            for (List<Integer> permutation : permutationsList) {
                for (int index = 0; index <= permutation.size(); index++) {
                    List<Integer> temporary = new ArrayList<>(permutation);
                    temporary.add(index, integer);
                    current.add(temporary);
                }
            }

            permutationsList = new ArrayList<>(current);
        }

        ArrayList<String> permutations = new ArrayList<>();

        for (List<Integer> array : permutationsList) {
            StringBuilder entry = new StringBuilder();

            for (int digit : array) {
                entry.append(digit);
            }

            permutations.add(entry.toString());
        }

        System.out.println(String.format("Permutations of b (%d): %s", this.b, permutations));
    }

    /*
     * აბრუნებს b-ს ჩანაწერში არსებულ ყველაზე დიდ ციფრს.
     * */
    @Override
    public int getMaximumDigitOfB() {
        int dividend = Math.abs(this.b);
        int maximumDigit = -1;
        int remainder;

        while (dividend != 0) {
            remainder = dividend % 10;

            if (remainder > maximumDigit) {
                maximumDigit = remainder;
            }

            dividend /= 10;
        }

        System.out.println(String.format("The maximum digit of b (%d) is: %d", this.b, maximumDigit));

        return maximumDigit;
    }
}
