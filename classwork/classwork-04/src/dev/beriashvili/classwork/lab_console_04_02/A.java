package dev.beriashvili.classwork.lab_console_04_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class A implements Interface {
    /*
     * განსაზღვრეთ კლასი A: ორი მთელი ტიპის ცვლადით a, b, მთელი ტიპის 12
     * ელემენტიანი m მასივით;
     * */
    private int a, b;
    private int[] m = new int[12];

    /*
     * ანიჭებს a და b ცვლადებს შემთხვევით მნიშვნელობებს [10; 25]
     * შუალედიდან ;
     * */
    @Override
    public void assignValuesFromRange() {
        Random random = new Random();

        this.a = random.nextInt(16) + 10;
        this.b = random.nextInt(16) + 10;
    }

    /*
     * აბრუნებს a და b ცვლადების მნიშვნელობებს;
     * */
    @Override
    public int[] getValues() {
        return new int[]{this.a, this.b};
    }

    /*
     * აბრუნებს a და b ცვლადების მნიშვნელობებს შესაბამის სიმბოლოებს;
     * */
    @Override
    public HashMap getCharsFromIntegerValues() {
        HashMap<Integer, Character> characterHashMap = new HashMap<>();

        characterHashMap.put(this.a, (char) (this.a + 'a'));
        characterHashMap.put(this.b, (char) (this.b + 'a'));

        System.out.println(characterHashMap.toString());

        return characterHashMap;
    }

    /*
     * ანიჭებს m მასივს შემთხვევით მნიშვნელობებს [-10; 60] შუალედიდან;
     * */
    @Override
    public void assignValuesToArrayFromRange() {
        Random random = new Random();

        for (int index = 0; index < this.m.length; index++) {
            m[index] = random.nextInt(71) - 10;
        }
    }

    /*
     * ბეჭდავს m მასივს ლუწ ელემენტებს;
     * */
    @Override
    public void printEvenIntegerElements() {
        ArrayList<Integer> evenIntegerElements = new ArrayList<>();

        for (int evenIntegerElement : this.m) {
            if ((evenIntegerElement & 1) == 0) {
                evenIntegerElements.add(evenIntegerElement);
            }
        }

        System.out.println(String.format("Even integers from the array: %s", evenIntegerElements.toString()));
    }

    /*
     * ბეჭდავს m მასივს დადებითი ელემენტების ჯამს;
     * */
    @Override
    public void printSumOfPositiveElements() {
        int positiveElementSum = 0;

        for (int element : this.m) {
            if (element > 0) {
                positiveElementSum += element;
            }
        }

        if (positiveElementSum > 0) {
            System.out.println(String.format("The sum of the positive integer elements from the array: %d", positiveElementSum));
        } else {
            System.out.println("The array is devoid of positive numbers.");
        }
    }

    /*
     * ბეჭდავს m მასივს დადებით ელემენტებს შორის მინიმალურს.
     * */
    @Override
    public void printMinimumOfPositiveIntegerElements() {
        ArrayList<Integer> positiveIntegerElements = new ArrayList<>();
        int minimumOfPositiveIntegerElements;

        for (int element : this.m) {
            if (element > 0) {
                positiveIntegerElements.add(element);
            }
        }

        try {
            minimumOfPositiveIntegerElements = Collections.min(positiveIntegerElements);

            System.out.println(String.format("The minimum of the positive integer elements from the array: %d", minimumOfPositiveIntegerElements));
        } catch (Exception error) {
            System.out.println("The array is devoid of positive numbers.");
        }
    }
}
