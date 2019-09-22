public class Exercise_09 {
    /*
     * განსაზღვრეთ 8 ელემენტიანი ნამდვილ რიცხვთა მასივი, დაბეჭდეთ მასივის ელემენტები, მასივის უდიდესი და უმცირესი ელემენტი.
     * */
    public static void main() {
        double[] realNumbers = new double[8];

        for (int index = 0; index < realNumbers.length; index++) {
            realNumbers[index] = Math.random();
        }

        double minimum = realNumbers[0], maximum = realNumbers[0];

        for (double realNumber : realNumbers) {
            System.out.println(realNumber);

            if (realNumber < minimum) {
                minimum = realNumber;
            }

            if (realNumber > maximum) {
                maximum = realNumber;
            }
        }

        System.out.println();

        if (minimum != maximum) {
            System.out.println(String.format("Minimum: %f", minimum));
            System.out.println(String.format("Maximum: %f", maximum));
        } else {
            System.out.println("Minimum = Maximum");
        }
    }
}
