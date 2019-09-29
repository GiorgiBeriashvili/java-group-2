package dev.beriashvili.classwork;

import java.util.Scanner;

public class Exercise_07 {
    /*
     * იპოვეთ ორი მთელი რიცხვის უდიდესი საერთო გამყოფი და უმცირესი საერთო ჯერადი.(ევკლიდეს ალგორითმი).
     * */
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int firstInt = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInt = scanner.nextInt();

        System.out.println(String.format("Greatest common divisor of %d and %d = %d", firstInt, secondInt, greatestCommonDivisorOf(firstInt, secondInt)));
        System.out.println(String.format("Least common multiple of %d and %d = %d", firstInt, secondInt, leastCommonMultipleOf(firstInt, secondInt)));
    }

    private static int greatestCommonDivisorOf(int firstInt, int secondInt) {
        if (secondInt == 0) {
            return firstInt;
        }

        return greatestCommonDivisorOf(secondInt, firstInt % secondInt);
    }

    private static int leastCommonMultipleOf(int firstInt, int secondInt) {
        return firstInt * secondInt / greatestCommonDivisorOf(firstInt, secondInt);
    }
}
