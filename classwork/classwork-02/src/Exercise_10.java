import java.util.Arrays;

public class Exercise_10 {
    /*
     * განსაზღვრეთ 8 ელემენტიანი ნამდვილ რიცხვთა მასივი, დაალაგეთ მასივი ზრდადობით, დაბეჭდეთ მასივი.
     * */
    public static void main() {
        double[] realNumbers = new double[8];

        for (int index = 0; index < realNumbers.length; index++) {
            realNumbers[index] = Math.random();
        }

        Arrays.sort(realNumbers);

        System.out.println(Arrays.toString(realNumbers));
    }
}
