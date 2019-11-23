package dev.beriashvili.homework;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Utils {
    static void addRandomIntegers(List<Integer> integerList, int amount) {
        for (int index = 0; index < amount; index++) {
            integerList.add(getRandomInteger());
        }
    }

    static void addRandomIntegers(List<Integer> integerList, int amount, int minimumBound, int maximumBound) {
        for (int index = 0; index < amount; index++) {
            integerList.add(getRandomInteger(minimumBound, maximumBound));
        }
    }

    private static int getRandomInteger() {
        int minimumBound = Integer.MIN_VALUE;
        int maximumBound = Integer.MAX_VALUE;

        return ThreadLocalRandom.current().nextInt(minimumBound, maximumBound);
    }

    static int getRandomInteger(int minimumBound, int maximumBound) {
        return ThreadLocalRandom.current().nextInt(minimumBound, maximumBound);
    }

    static void printList(List list, String message) {
        System.out.println(String.format("%s: %s", message, list.toString()));
    }

    static void main() {
        Exercises exercises = new Exercises();

        System.out.println("Exercise one: ");
        exercises.exerciseOne();

        System.out.println();

        System.out.println("Exercise two: ");
        exercises.exerciseTwo();
    }
}
