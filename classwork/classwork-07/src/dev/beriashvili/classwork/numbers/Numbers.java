package dev.beriashvili.classwork.numbers;

import java.util.*;

public class Numbers implements NumberOperations {
    public void main() {
        System.out.println(isPalindrome(568765));
        System.out.println(String.format("Non-equal element input number: %s", checkEquality()));
        printTwofoldProduct();
        operateMatrix(1, 10);
        System.out.println(String.format("The element count of the matrix: %d", getElementCount()));
    }

    /*
     * 1. ნატურალურ რიცხვს ეწოდება პოლიდრომი, თუ ამ რიცხვში ციფრების შებრუნებული რიგით ჩაწერის
     * შემდეგ რიცხვის სიდიდე არ შეიცვლება. მაგ 121, 13431 და ა.შ. აჩვენეთ შეტანილი ნატურალური რიცხვი
     * არის თუ არა პოლიდრომი.
     * */
    @Override
    public boolean isPalindrome(int naturalNumber) {
        String iterable = String.valueOf(naturalNumber);

        for (int left = 0, right = iterable.length() - 1; left < right; left++, right--) {
            if (iterable.charAt(left) != iterable.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    /*
     * 2. შეიტანეთ ხუთი მთელი რიცხვი. თუ რიცხვებიდან რომელიმე სამი არ უდრის ერთმანეთს, დაბეჭდეთ შეტ-
     * ყობინება „NO“, ხოლო თუ რომელიმე სამი ერთმანეთის ტოლია, მაშინ დაბეჭდეთ დანარჩენი ორის შეტანის
     * რიგი. (ანუ მერამდენე რიცხვად მოხდა შეტანა).
     * */
    @Override
    public String checkEquality() {
        int[] integerArray = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < integerArray.length; index++) {
            System.out.print(String.format("Enter integer #%d: ", index + 1));
            integerArray[index] = scanner.nextInt();
        }

        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for (int index = 0; index < integerArray.length; index++) {
            integerHashMap.put(index, integerArray[index]);
        }

        int integer;

        int currentEqualCount;
        int maximumEqualCount = 0;

        int specialInteger = -1;

        for (int index = 0; index < integerArray.length; index++) {
            for (integer = index + 1, currentEqualCount = 1; integer < integerArray.length; integer++) {
                if (integerArray[index] == integerArray[integer]) {
                    currentEqualCount++;
                }

                if (currentEqualCount == 3) {
                    specialInteger = index;
                }
            }

            if (currentEqualCount > maximumEqualCount) {
                maximumEqualCount = currentEqualCount;
            }
        }

        if (maximumEqualCount == 3) {
            StringBuffer result = new StringBuffer();

            for (Map.Entry<Integer, Integer> entry : integerHashMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();

                if (value != integerArray[specialInteger]) {
                    result.append(String.format("%d ", key + 1));
                }
            }

            result.append(String.format("(from the array %s)", Arrays.toString(integerArray)));

            return String.valueOf(result);
        } else {
            return "NO";
        }
    }

    /*
     * 3. შეიტანეთ მთელი დადებითი რიცხვი, დაბეჭდეთ რიცხვის შებრუნებული რიგის გაორკეცებული ნამ-
     * რავლი. გაითვალისწინეთ ბოლოში ნულების არსებობა.
     * */
    @Override
    public void printTwofoldProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int positiveInteger = scanner.nextInt();

        while (positiveInteger < 1) {
            System.out.println("Please enter a positive integer (e.g. 1, 2, 3...).");

            System.out.print("Enter a positive integer: ");
            positiveInteger = scanner.nextInt();
        }

        int temporaryInteger = positiveInteger;
        StringBuffer reverse = new StringBuffer();

        while (temporaryInteger > 0) {
            reverse.append(temporaryInteger % 10);
            temporaryInteger /= 10;
        }

        System.out.println(String.format("Reverse of %d: %s", positiveInteger, reverse));

        int parsedReverse = Integer.parseInt(String.valueOf(reverse));
        int twofoldProduct = parsedReverse * 2;

        System.out.println(String.format("Twofold product of %d: %d", parsedReverse, twofoldProduct));
    }

    /*
     * 4. განსაზღვრეთ 6x5 ნამდვილი ტიპის მატრიცა. ელემენტებს მიანიჭეთ შემთხვევითი მნიშვნელობები [a; b](a
     * და b მთელი რიცხვებია). დაალაგეთ კლებადობით მატრიცის პირველი სვეტი, მიღებული პირველი სვეტის
     * შესაბამისად გადაანაცვლეთ სტრიქონები, დაბეჭდეთ თავდაპირველი და მიღებული მატრიცები.
     * */
    @Override
    public void operateMatrix(int a, int b) {
        int rows = 6;
        int columns = 5;

        double[][] matrix = new double[rows][columns];

        int minimumBound = Math.min(a, b);
        int maximumBound = Math.max(a, b);

        Random random = new Random();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = random.nextDouble() * (maximumBound - minimumBound) + minimumBound;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        double[] indicesArray = new double[rows];

        for (int row = 0; row < rows; row++) {
            indicesArray[row] = matrix[row][0];
        }

        Arrays.sort(indicesArray);

        double[][] sortedMatrix = new double[rows][columns];

        for (int index = 0; index < indicesArray.length; index++) {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (indicesArray[index] == matrix[row][0]) {
                        sortedMatrix[index][column] = matrix[row][column];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(sortedMatrix));
    }

    /*
     * 5. განსაზღვრეთ 100 ელემენტიანი მთელი ტიპის მასივი. ელემენტებს მიანიჭეთ შემთხვევითი მნიშ-
     * ვნელობები [0; 99]-შუალედიდან. დათვალეთ რამდენი ელემენტია მის ინდექსზე მეტი.
     * */
    @Override
    public int getElementCount() {
        int[] array = new int[100];

        Random random = new Random();

        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(100);
        }

        int count = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index] > index) {
                count++;
            }
        }

        return count;
    }
}
