package dev.beriashvili.classwork;

import java.util.Scanner;

public class Exercise_08 {
    /*
     * დაბეჭდეთ მთელი რიცხვები M-დან N-მდე.
     * */
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int firstInt = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInt = scanner.nextInt();

        if (firstInt < secondInt) {
            while (firstInt < secondInt) {
                System.out.println(firstInt++);
            }
        } else if (firstInt > secondInt) {
            while (firstInt > secondInt) {
                System.out.println(firstInt--);
            }
        }
    }
}
