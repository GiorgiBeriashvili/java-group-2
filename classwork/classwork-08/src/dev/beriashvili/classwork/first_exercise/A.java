package dev.beriashvili.classwork.first_exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class A implements MainInterface {
    /*
     * განსაზღვრეთ კლასი A: მთელი ტიპის m[15] მასივით; 4 მეთოდით; მეთოდი 1-ის
     * იმპლემენტაციისთვის გამოიყენეთ ინტერფეისი.
     * */
    private int a, b;
    private int[] m = new int[15];

    private Random random = new Random();

    public void main() {
        // Assign random values from specific range to array's elements
        setData();
        setRandomValues(this.m, this.a, this.b);

        // Print the array
        System.out.println(Arrays.toString(m));

        // Get the sum of the array's elements
        System.out.println(String.format("The sum of array's elements: %d", getElementSum(this.m)));

        // Get the product of the array's elements
        System.out.println(String.format("The product of array's elements: %d", getElementProduct(this.m)));

        // Print even elements of the array
        printEvenElements(this.m);
    }

    private void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        this.a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        this.b = scanner.nextInt();
    }

    /*
     * მეთოდი 1: ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [a; b] შუალე-
     * დუდან, a და b-ს მნიშვნელობების შეტანა ხდება კლავიატურიდან;
     * */
    @Override
    public void setRandomValues(int[] array, int a, int b) {
        int minimumBound = Math.min(a, b);
        int maximumBound = Math.max(a, b);

        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;
        }
    }

    /*
     * მეთოდი 2: აბრუნებს მასივის იმ ელემენტების მნიშვნელობათა ჯამს, რომლის მნი-
     * შვნელობა თავის ინდექსზე ნაკლებია;
     * */
    private int getElementSum(int[] array) {
        int elementSum = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index] < index) {
                elementSum += array[index];
            }
        }

        return elementSum;
    }

    /*
     * მეთოდი 3: აბრუნებს მასივის იმ ელემენტების ნამრავლს, რომლის მნი-
     * შვნელობა თავის ინდექსზე მეტია;
     * */
    private int getElementProduct(int[] array) {
        int elementProduct = 1;

        for (int index = 0; index < array.length; index++) {
            if (array[index] > index) {
                elementProduct *= array[index];
            }
        }

        return elementProduct;
    }

    /*
     * მეთოდი 4: ბეჭდავს მასივში არსებულ ლუწ რიცხვებს.
     * */
    private void printEvenElements(int[] array) {
        System.out.print("Even integers from the array are: ");

        for (int evenInteger : array) {
            if ((evenInteger & 1) == 0) {
                System.out.print(String.format("%d ", evenInteger));
            }
        }
    }
}
