package dev.beriashvili.classwork.lab_console_04_03;

class Utils {
    static void main() {
        A a = new A();
        a.a = 248;
        a.b = 233;
        a.printIntegersBetweenTwoValues();
        a.printDivisorsOfA();
        a.printPrimeDivisorsOfB();
        System.out.println(String.format("The most frequent digit of b (%d) is: %d", a.b, a.getTheMostFrequentDigitOfB()));

        B b = new B();
        b._a(-100, 100);
        b._b(Integer.MIN_VALUE, Integer.MAX_VALUE);
        b.printThreeRandomIntegersBetweenTwoValues();
        b.printThreeMultiplesOfA();
        b.printEveryIntegerCreatedFromTheDigitsOfB();
        b.getMaximumDigitOfB();
    }
}
