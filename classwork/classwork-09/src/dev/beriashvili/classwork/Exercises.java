package dev.beriashvili.classwork;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Exercises {
    private Random random = new Random();

    /*
     * 1. ჩაწერეთ კოლექციაშიში ხუთი შემთხვევითი მთელი რიცხვი და დაბეჭდეთ.
     * */
    void exerciseOne() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);

        Utils.printList(integerArrayList);
    }

    /*
     * 2. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. დაბეჭდეთ პირდაპირი
     * და შებრუნებული რიგით.
     * */
    void exerciseTwo() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);

        Utils.printList(integerArrayList);

        Collections.reverse(integerArrayList);
        Utils.printList(integerArrayList);
    }

    /*
     * 3. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. დაალაგეთ ზრდადო-
     * ბით და დაბეჭდეთ.
     * */
    void exerciseThree() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);

        Collections.sort(integerArrayList);
        Utils.printList(integerArrayList);
    }

    /*
     * 4. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. დაალაგეთ კლებადო-
     * ბით და დაბეჭდეთ.
     * */
    void exerciseFour() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);

        Collections.sort(integerArrayList);
        Collections.reverse(integerArrayList);
        Utils.printList(integerArrayList);
    }

    /*
     * 5. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. ჩაამატეთ ბოლოში სამი
     * შემთხვევითი რიცხვი. დაბეჭდეთ თავდაპირველი და მიღებული კოლექცია.
     * */
    void exerciseFive() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);
        Utils.printList(integerArrayList);

        Utils.addRandomIntegers(integerArrayList, 3);
        Utils.printList(integerArrayList);
    }

    /*
     * 6. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. ჩაამატეთ შემ-
     * თხვევითი რიცხვები ყოველი მომდევნო ინდექსის შემდეგ. დაბეჭდეთ თავ-
     * დაპირველი და მიღებული კოლექცია.
     * */
    void exerciseSix() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        for (int index = 0; index < 5; index++) {
            integerLinkedList.add(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }

        Utils.printList(integerLinkedList);

        for (int index = 0; index < integerLinkedList.size(); index += 2) {
            integerLinkedList.add(index + 1, ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }

        Utils.printList(integerLinkedList);
    }

    /*
     * 7. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. ჩაამატეთ შემთხვევითი
     * რიცხვი კლავიატურიდან შეტანილი n ინდექსის შემდეგ. დაბეჭდეთ თავდაპირვე-
     * ლი და მიღებული კოლექცია.
     * */
    void exerciseSeven() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < 5; index++) {
            integerLinkedList.add(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }

        Utils.printList(integerLinkedList);

        System.out.print(String.format("Enter the index [0; %d]: ", integerLinkedList.size() - 1));
        integerLinkedList.add(scanner.nextInt() + 1, ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));

        Utils.printList(integerLinkedList);
    }

    /*
     * 8. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. წაშალეთ პირველი 3
     * რიცხვი. დაბეჭდეთ თავდაპირველი და მიღებული კოლექცია.
     * */
    void exerciseEight() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);
        Utils.printList(integerArrayList);

        integerArrayList.removeAll(integerArrayList.subList(0, 3));
        Utils.printList(integerArrayList);
    }

    /*
     * 9. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. წაშალეთ კლავიატუ-
     * რიდან შეტანილი n ინდექსზე მდგომი ელემენტი. დაბეჭდეთ თავდაპირველი და
     * მიღებული კოლექცია.
     * */
    void exerciseNine() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);
        Utils.printList(integerArrayList);

        Scanner scanner = new Scanner(System.in);

        System.out.print(String.format("Remove an element from the array by specifying an index [0; %d]: ", integerArrayList.size() - 1));
        int specificIndex = scanner.nextInt();

        integerArrayList.remove(specificIndex);
        Utils.printList(integerArrayList);
    }

    /*
     * 10. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. წაშალეთ ლუწ
     * ინდექსიანი ელემენტები. დაბეჭდეთ თავდაპირველი და მიღებული კოლექცია.
     * */
    void exerciseTen() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Integer[] evenIndexArray;

        Utils.addRandomIntegers(integerArrayList, 5);
        Utils.printList(integerArrayList);

        if ((integerArrayList.size() & 1) == 1) {
            evenIndexArray = new Integer[(integerArrayList.size() / 2) + 1];
        } else {
            evenIndexArray = new Integer[integerArrayList.size() / 2];
        }

        int currentIndex = 0;

        for (int index = 0; index < integerArrayList.size(); index++) {
            if ((index & 1) != 1) {
                evenIndexArray[currentIndex] = integerArrayList.get(index);

                currentIndex++;
            }
        }

        integerArrayList.removeAll(Arrays.asList(evenIndexArray));
        Utils.printList(integerArrayList);
    }

    /*
     * 11. ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. წაშალეთ 30-ის ტოლი
     * ელემენტები. დაბეჭდეთ თავდაპირველი და მიღებული კოლექცია.
     * */
    void exerciseEleven() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 5);
        Utils.printList(integerArrayList);

        integerArrayList.removeIf(integer -> integer == 30);
        Utils.printList(integerArrayList);
    }

    /*
     * 12. ჩაწერეთ კოლექციაში 20 შემთხვევითი მთელი რიცხვი. გადაწერეთ ახალ
     * კოლექციაში 7-დან 15-მდე ინდექსებში მდგომი ელემენტები. დაბეჭდეთ ორივე
     * კოლექცია.
     * */
    void exerciseTwelve() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Utils.addRandomIntegers(integerArrayList, 20);
        Utils.printList(integerArrayList);

        List<Integer> newIntegerArrayList = integerArrayList.subList(7, 15);
        Utils.printList(newIntegerArrayList);
    }

    /*
     * 13. ჩაწერეთ კოლექციაში 20 შემთხვევითი 10 სიმბოლოიანი სტრიქონი. გადაწერეთ
     * ახალ კოლექციაში ყველა ის ელემენტი, რომელიც შეიცავს ‘x’ სიმბოლოს.
     * დაბეჭდეთ ორივე კოლექცია.
     * */
    void exerciseThirteen() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> xArrayList = new ArrayList<>();

        final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int index = 0; index < 20; index++) {
            StringBuilder stringBuilder = new StringBuilder(10);

            for (int character = 0; character < 10; character++) {
                stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
            }

            stringArrayList.add(new String(stringBuilder));
        }

        Utils.printList(stringArrayList);

        for (String strings : stringArrayList) {
            if (strings.contains("x")) {
                xArrayList.add(strings);
            }
        }

        Utils.printList(xArrayList);
    }

    /*
     * 14. დაწერეთ პროგრამა, რომელიც ათობით რიცხვს გადაიყვანს ორობითში.
     * */
    void exerciseFourteen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal: ");
        int decimal = scanner.nextInt();

        StringBuilder binary = new StringBuilder();
        Stack<Integer> digits = new Stack<>();

        int origin = decimal;

        if (decimal >= 0) {
            binary.append("0 ");
        } else {
            binary.append("1 ");
        }

        decimal = Math.abs(decimal);

        while (decimal != 0) {
            int digit = decimal % 2;

            digits.push(digit);

            decimal /= 2;
        }

        while (!digits.empty()) {
            binary.append(digits.pop());
        }

        decimal = origin;

        System.out.println(String.format("Decimal %d to binary: %s", decimal, binary.toString()));
    }

    /*
     * 15. დაწერეთ პროგრამა, რომელიც ორობით რიცხვს გადაიყვანს ათობითში.
     * */
    void exerciseFifteen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary: ");
        String binary = scanner.nextLine();

        System.out.println(String.format("Binary %s to decimal: %d", binary, Integer.parseInt(binary, 2)));
    }
}
