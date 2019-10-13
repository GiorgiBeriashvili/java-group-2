package dev.beriashvili.classwork.lab_console_04_01;

class A implements Interface {
    /*
     * განსაზღვრეთ კლასი A: ორი მთელი ტიპის ცვლადით a=10, b=29;
     * */
    private int a = 10, b = 29;

    /*
     * ბეჭდავს “Hello OPP”;
     * */
    @Override
    public void greet() {
        System.out.println("Hello OPP");
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
        System.out.println(String.format("b = %d", this.b));
    }

    /*
     * ბეჭდავს a და b ცვლადების ჯამს;
     * */
    @Override
    public void printSum() {
        System.out.println(String.format("a + b = %d", this.a + this.b));
    }

    /*
     * აბრუნებს a და b ცვლადების ჯამს;
     * */
    @Override
    public int getSum() {
        return this.a + this.b;
    }

    /*
     * აბრუნებს a და b ცვლადების ნამრავლს;
     * */
    @Override
    public int getProduct() {
        return this.a * this.b;
    }

    /*
     * ანიჭებს a და b ცვლადებს 5-ის და 6-ის ტოლ მნიშვნელობებს.
     * */
    @Override
    public void assignValues() {
        this.a = 5;
        this.b = 6;
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
     * Unimplemented method.
     * */
    @Override
    public void setValueOfA() {
    }

    /*
     * Unimplemented method.
     * */
    @Override
    public void printTenPlusB() {
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
