package dev.beriashvili.exam.exercises;

import java.util.ArrayList;
import java.util.Random;

public class Matrix implements RandomAssignation {
    /*
     * განსაზღვრეთ კლასი: a და b მთელი ტიპის ცვლადებით,
     * მთელი ტიპის m[10][10] მასივით; მეთოდებით;
     * პირველი ორი მეთოდისთვის გამოიყენეთ ინტერფეისი.
     * */
    private int a, b;
    private int[][] m;

    private Random random = new Random();

    public void main() {
        assignRandomValues();
        assignRandomElements();
        System.out.println(getMaximumNegativesByRow());
        printArrayElements();
        System.out.println(getOccurrenceCountOfSeven());
    }

    /*
     * მეთოდი 1: ანიჭებს a და b-ს შემთხვევით მნიშვნელობებს [-100; 100];
     * */
    @Override
    public void assignRandomValues() {
        int minimumBound = -100;
        int maximumBound = 100;

        this.a = this.random.nextInt(maximumBound - minimumBound + 1) + minimumBound;
        this.b = this.random.nextInt(maximumBound - minimumBound + 1) + minimumBound;
    }

    /*
     * მეთოდი 2: ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [a; b] შუალედიდან;
     * */
    @Override
    public void assignRandomElements() {
        int rows = 10;
        int columns = 10;

        int minimumBound = Math.min(this.a, this.b);
        int maximumBound = Math.max(this.a, this.b);

        this.m = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                m[row][column] = this.random.nextInt(maximumBound - minimumBound + 1) + minimumBound;
            }
        }
    }

    /*
     * მეთოდი 3: აბრუნებს მასივის თითოეულ სვეტში არსებული უარყოფითი რიცხვების მაქსიმუმების მასივს;
     * */
    private ArrayList<Integer> getMaximumNegativesByRow() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int row = 0, maximumNegative = 0; row < this.m.length; row++, maximumNegative = 0) {
            for (int column = 0; column < this.m[0].length - 1; column++) {
                int currentElement = this.m[row][column];

                if (currentElement < 0) {
                    if (maximumNegative == 0 || currentElement > maximumNegative) {
                        maximumNegative = currentElement;
                    }
                }
            }

            if (maximumNegative < 0) {
                integerArrayList.add(maximumNegative);
            }
        }

        return integerArrayList;
    }

    /*
     * მეთოდი 4: ბეჭდავს m მასივის ელემენტებს ინდექსების ჩვენებით;
     * */
    private void printArrayElements() {
        for (int row = 0; row < this.m.length; row++) {
            for (int column = 0; column < this.m[0].length; column++) {
                int currentElement = this.m[row][column];

                System.out.println(String.format("Element %d located at [%d; %d] index of the array.", currentElement, row, column));
            }
        }
    }

    /*
     * მეთოდი 5: აბრუნებს მასივიდან 7-ის ტოლი ელემენტების რაოდენობას;
     * */
    private int getOccurrenceCountOfSeven() {
        int occurrenceCount = 0;

        for (int[] row : this.m) {
            for (int column = 0; column < this.m[0].length; column++) {
                int currentElement = row[column];

                if (currentElement == 7) {
                    occurrenceCount++;
                }
            }
        }

        return occurrenceCount;
    }
}
