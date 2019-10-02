package dev.beriashvili.homework;

import java.util.Scanner;

class C {
    /*
    1. განსაზღვრეთ კლასი C: სამი მთელი ტიპის ცვლადით a, b, c; 6 მეთოდით;
        მეთოდი 1: ანიჭებს a, b და c ცვლადებს მნიშვნელობებს კლავიატურიდან;
        მეთოდი 2: აბრუნებს a-ს მნიშვნელობის ბოლო ციფრს;
        მეთოდი 3: აბრუნებს b-ს მნიშვნელობის პირველ ციფრს;
        მეთოდი 4: აბრუნებს c-ს მნიშვნელობის ციფრთა ჯამს;
        მეთოდი 5: ბეჭდავს მეთოდი 2-ის მნიშნველობისა და მეთოდი 3-ის მნიშვნელობის
        ნამრავლს;
        მეთოდი 6: ბეჭდავს მეთოდი 3-ის მნიშნველობისა და მეთოდი 5-ის მნიშვნელობის
        ჯამს.
     */

    private int a, b;
    int c;

    void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        b = scanner.nextInt();

        System.out.print("Enter the value of c: ");
        c = scanner.nextInt();
    }

    private int getLastDigit() {
        a = Math.abs(a);

        return a % 10;
    }

    private int getFirstDigit() {
        b = Math.abs(b);

        while (b >= 10) {
            b /= 10;
        }

        return b;
    }

    int getDigitSum() {
        int digitSum = 0;

        c = Math.abs(c);

        while (c > 0) {
            digitSum += c % 10;
            c /= 10;
        }

        return digitSum;
    }

    void printProduct() {
        System.out.println(String.format("%d * %d = %d", getLastDigit(), getFirstDigit(), getLastDigit() * getFirstDigit()));
    }

    void printSum() {
        System.out.println(String.format("%d + %d = %d", getFirstDigit(), getLastDigit() * getFirstDigit(), getFirstDigit() + getLastDigit() * getFirstDigit()));
    }
}
