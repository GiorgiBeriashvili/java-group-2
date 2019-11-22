package dev.beriashvili.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Utils {
    static void addRandomIntegers(ArrayList<Integer> integerArrayList, int amount) {
        for (int index = 0; index < amount; index++) {
            integerArrayList.add(getRandomInteger());
        }
    }

    private static int getRandomInteger() {
        int minimumBound = Integer.MIN_VALUE;
        int maximumBound = Integer.MAX_VALUE;

        return ThreadLocalRandom.current().nextInt(minimumBound, maximumBound);
    }

    static void printList(List list) {
        System.out.println(list.toString());
    }

    void main() {
        Exercises exercises = new Exercises();

        exercises.exerciseOne();
        exercises.exerciseTwo();
        exercises.exerciseThree();
        exercises.exerciseFour();
        exercises.exerciseFive();
        exercises.exerciseSix();
        exercises.exerciseSeven();
        exercises.exerciseEight();
        exercises.exerciseNine();
        exercises.exerciseTen();
        exercises.exerciseEleven();
        exercises.exerciseTwelve();
        exercises.exerciseThirteen();
        exercises.exerciseFourteen();
        exercises.exerciseFifteen();
    }
}
