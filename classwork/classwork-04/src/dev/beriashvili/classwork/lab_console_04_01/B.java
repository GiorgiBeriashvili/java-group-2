package dev.beriashvili.classwork.lab_console_04_01;

import java.util.Random;
import java.util.Scanner;

public class B implements Interface {
    /*
     * განსაზღვრეთ კლასი B: მთელი ტიპის ცვლადით a=33, ნამდვილი ტიპის ცვლადით
     * b=9.7, სიმბოლური ტიპის ცვლადით s=’#’;
     * */
    private int a = 33;
    private double b = 9.7;
    private char s = '#';

    /*
     * Unimplemented method.
     * */
    @Override
    public void greet() {
    }

    /*
     * ბეჭდავს s ცვლადის მნიშვნელობას;
     * */
    @Override
    public void printValueOfS() {
        System.out.println(String.format("s = %c", this.s));
    }

    /*
     * ბეჭდავს a ცვლადის მნიშვნელობას;
     * */
    @Override
    public void printValueOfA() {
        System.out.println(String.format("a = %d", this.a));
    }

    /*
     * ბეჭდავს b ცვლადის მნიშვნელობას;
     * */
    @Override
    public void printValueOfB() {
        System.out.println(String.format("b = %f", this.b));
    }

    /*
     * აბრუნებს a და b ცვლადების სხვაობას;
     * */
    @Override
    public double getDifference() {
        return this.a - this.b;
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printSum() {
    }

    /*
     * აბრუნებს a და b ცვლადების განაყოფს;
     * */
    @Override
    public double getQuotient() {
        return this.a / this.b;
    }

    /*
     * ანიჭებს ცვლადებს სხვა ნებისმიერ შესაბამისი ტიპის მნიშვნელობას;
     * */
    @Override
    public void assignValues() {
        Random random = new Random();

        this.a = random.nextInt();
        this.b = random.nextDouble();
        this.s = (char) (random.nextInt(26) + 'a');
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
     * ბეჭდავს b ცვლადზე 10-ით მეტ რიცხვს.
     * */
    @Override
    public void printTenPlusB() {
        System.out.println(String.format("10 + b = %f", 10 + this.b));
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
    public void printIntegerValues() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printCharValues() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printSumProductDifferenceQuotient() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void setValueOfB() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void setValuesOfChars() {
    }
}
