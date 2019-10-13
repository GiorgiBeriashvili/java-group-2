package dev.beriashvili.classwork.lab_console_04_01;

import java.util.Scanner;

public class C implements Interface {
    /*
     * განსაზღვრეთ კლასი C: ორი მთელი ტიპის ცვლადით a=10, b=9, ორი სიმბოლური
     * ტიპის ცვლადით s=’#’, h=’@’;
     * */
    private int a = 10, b = 9;
    private char s = '#', h = '@';

    /*
     * Unimplemented method.
     * */
    @Override
    public void greet() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printValueOfA() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printValueOfB() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printSum() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public int getSum() {
        return 0;
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public int getProduct() {
        return 0;
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printValueOfS() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void assignValues() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public double getDifference() {
        return 0;
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public double getQuotient() {
        return 0;
    }

    /*
     * ანიჭებს a ცვლადს მნიშვნელობას კლავიატურიდან;
     * */
    @Override
    public void setValueOfA() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        this.a = scanner.nextInt();
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printTenPlusB() {
    }

    /*
     * ბეჭდავს მთელი ტიპის ცვლადების მნიშვნელობებს;
     * */
    @Override
    public void printIntegerValues() {
        System.out.println(String.format("a = %d", this.a));
        System.out.println(String.format("b = %d", this.b));
    }

    /*
     * ბეჭდავს სიმბოლური ტიპის ცვლადების მნიშვნელობებს;
     * */
    @Override
    public void printCharValues() {
        System.out.println(String.format("s = %c", this.s));
        System.out.println(String.format("h = %c", this.h));
    }

    /*
     * ბეჭდავს a და b ცვლადების ჯამს, ნამრავლს, სხვაობას, ნაშთიან გაყოფას
     * ცალ-ცალკე სტრიქონზე;
     * */
    @Override
    public void printSumProductDifferenceQuotient() {
        System.out.println(String.format("a + b = %d", this.a + this.b));
        System.out.println(String.format("a * b = %d", this.a * this.b));
        System.out.println(String.format("a - b = %d", this.a - this.b));
        System.out.println(String.format("a / b = %d", this.a / this.b));
    }

    /*
     * ანიჭებს b ცვლადს მნიშვნელობას კლავიატურიდან;
     * */
    @Override
    public void setValueOfB() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of b: ");
        this.b = scanner.nextInt();
    }

    /*
     * ანიჭებს სიმბოლური ტიპის ცვლადებს მნიშვნელობებს კლავიატურიდან;
     * */
    @Override
    public void setValuesOfChars() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of s: ");
        this.s = scanner.next().charAt(0);

        System.out.print("Enter the value of h: ");
        this.h = scanner.next().charAt(0);
    }
}
