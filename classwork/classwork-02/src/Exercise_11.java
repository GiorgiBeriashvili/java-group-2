import java.util.Arrays;

public class Exercise_11 {
    /*
     * განსაზღვრეთ 8 ელემენტიანი ნამდვილ რიცხვთა მასივი, ჩაწერეთ მასში შემთხვევითი რიცხვები, დაბეჭდეთ მასივი.
     * */
    public static void main() {
        double[] realNumbers = new double[8];

        for (int index = 0; index < realNumbers.length; index++) {
            realNumbers[index] = Math.random();
        }

        System.out.println(Arrays.toString(realNumbers));
    }
}
