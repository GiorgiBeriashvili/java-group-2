package dev.beriashvili.homework;

import java.util.Scanner;

class B extends A {
    /*
    2. განსაზღვრეთ კლასი A: მთელი ტიპის x ცვლადით. კონსტრუქტორით, 3
        მეთოდით.
        კონსტრუქტორი 1: ბეჭდავს „Hello“;
        მეთოდი 1: შეაქვს x ცვლადში მონაცემი კლავიატურიდან;
        მეთოდი 2: ბეჭდავს x+12-ს;
        მეთოდი 3: ადგენს x ლუწია თუ კენტი;
        განსაზღვრეთ კლასი A შვილობილის კლასი B: დაამატეთ მთელი ტიპის y ცვლადი,
        2 მეთოდი.
        მეთოდი 1: შეაქვს y ცვლადში მონაცემი კლავიატურიდან;
        მეთოდი 2: აბრუნებს x+y გამოსახულების მნიშვნელობას;
     */

    int y;

    void setData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of y: ");
        y = scanner.nextInt();
    }

    int getSum() {
        return x + y;
    }
}
