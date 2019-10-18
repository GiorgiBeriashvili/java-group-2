package dev.beriashvili.classwork.file_operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        exerciseOne();
        exerciseTwo();
        exerciseThree();
    }

    /*
     * მთელი 24, 39, -90 რიცხვები ჩაწერეთ data.txt ფაილში, ფაილი შექმენით myFiles
     * საქაღალდეში.
     * */
    private static void exerciseOne() {
        int[] integers = {24, 39, -90};

        try {
            FileWriter fileWriter = new FileWriter("data/myFiles/data.txt", true);

            for (int integer : integers) {
                fileWriter.write(String.format("%d\n", integer));
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*
     * 0-დან 100-მდე მთელი რიცხვები ჩაწერეთ data1.txt ფაილში. myFiles საქაღალდეში.
     * */
    private static void exerciseTwo() {
        try {
            FileWriter fileWriter = new FileWriter("data/myFiles/data1.txt", true);

            for (int integer = 0; integer < 100; integer++) {
                fileWriter.write(String.format("%d\n", integer));
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*
     * myFiles1 საქაღალდეში საქაღალდეში შექმენით 30 ფაილი, ფაილებში ჩაწერეთ სიტყვა
     * „Programmer“.
     * */
    private static void exerciseThree() {
        File file = new File("data/myFiles1");

        for (int index = 1; index <= 30; index++) {
            try {
                FileWriter fileWriter = new FileWriter(String.format("%s/%d", file, index));

                fileWriter.write("Programmer");

                fileWriter.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }
}
