package dev.beriashvili.homework;

import java.util.Collections;
import java.util.LinkedList;

class Exercises {
    /*
     * 1. ჩაწერეთ კოლექციაში თორმეტი შემთხვევითი მთელი რიცხვი. წაშალეთ ლუწ
     * ინდექსიანი ელემენტები. დაბეჭდეთ თავდაპირველი და მიღებული კოლექცია
     * ზრდადობით.
     * */
    void exerciseOne() {
        LinkedList<Integer> baseIntegerLinkedList = new LinkedList<>();

        Utils.addRandomIntegers(baseIntegerLinkedList, 12);
        Utils.printList(baseIntegerLinkedList, "Base");

        LinkedList<Integer> alteredIntegerLinkedList = new LinkedList<>(baseIntegerLinkedList);

        for (int index = 0, size = alteredIntegerLinkedList.size(); index < size; index++, size--) {
            alteredIntegerLinkedList.remove(index);
        }

        Utils.printList(alteredIntegerLinkedList, "Altered");

        Collections.sort(baseIntegerLinkedList);
        Utils.printList(baseIntegerLinkedList, "Sorted (Base)");

        Collections.sort(alteredIntegerLinkedList);
        Utils.printList(alteredIntegerLinkedList, "Sorted (Altered)");
    }

    /*
     * 2. ჩაწერეთ კოლექციაში თორმეტი შემთხვევითი მთელი რიცხვი [5, 10] შუალე-
     * დიდან. დაამატეთ ასევე შემთხვევითი რიცხვები ყოველი სამის ჯერადი ინდექსის
     * შემდეგ [20, 25] შუალედიდან. დაბეჭდეთ თავდაპირველი და მიღებული კოლექ-
     * ცია.
     * */
    void exerciseTwo() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        Utils.addRandomIntegers(integerLinkedList, 12, 5, 11);
        Utils.printList(integerLinkedList, "Base");

        for (int index = 0; index < integerLinkedList.size(); index += 4) {
            integerLinkedList.add(index + 1, Utils.getRandomInteger(20, 26));
        }

        Utils.printList(integerLinkedList, "Altered");
    }
}
