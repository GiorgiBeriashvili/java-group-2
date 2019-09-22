package dev.beriashvili.classwork;

import java.util.Scanner;

public class Exercise_02 {
    /*
     * დავწეროთ კოდი რომელიც გამოიტანს შეტანილი ორი მთელი რიცხვის შემთხვევაში, პირველის მეორეზე გაყოფის შედეგად მიღებულ მთელ შედეგს და მეორის პირველზე გაყოფის შედეგად მიღებულ ნაშთს. (ფორმატის გათვალისწინებით).
     * */
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int firstInt = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInt = scanner.nextInt();

        System.out.println(String.format("%d / %d = %d", firstInt, secondInt, firstInt / secondInt));
        System.out.println(String.format("%d %% %d = %d", secondInt, firstInt, secondInt % firstInt));
    }
}
