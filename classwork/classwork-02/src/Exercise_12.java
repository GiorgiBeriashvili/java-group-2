import java.util.Arrays;
import java.util.Random;

public class Exercise_12 {
    /*
     * განსაზღვრეთ 8 ელემენტიანი მთელ რიცხვთა მასივი, ჩაწერეთ მასში შემთხვევითი რიცხვები, დაალაგეთ მასივი კლებადობით, დაბეჭდეთ მასივი.
     * */
    public static void main() {
        int[] integers = new int[8];

        Random random = new Random();

        for (int index = 0; index < integers.length; index++) {
            integers[index] = random.nextInt();
        }

        descendingSelectionSort(integers);

        System.out.println(Arrays.toString(integers));
    }

    private static void descendingSelectionSort(int array[]) {
        for (int element = 0; element < array.length - 1; element++) {
            int minimumElement = element;

            for (int subElement = element + 1; subElement < array.length; subElement++)
                if (array[subElement] > array[minimumElement]) {
                    minimumElement = subElement;
                }

            int temporaryMinimumElement = array[minimumElement];

            array[minimumElement] = array[element];
            array[element] = temporaryMinimumElement;
        }
    }
}
