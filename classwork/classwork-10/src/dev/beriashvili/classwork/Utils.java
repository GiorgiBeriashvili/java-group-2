package dev.beriashvili.classwork;

import java.io.File;
import java.util.Scanner;

public class Utils {
    static void main() {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Select an exercise (first, second): ");

        while (true) {
            String exercise = scanner.nextLine();

            if (exercise.equals("first") || exercise.equals("1")) {
                System.out.println();

                firstExercise();

                break;
            } else if (exercise.equals("second") || exercise.equals("2")) {
                System.out.println();

                secondExercise();

                break;
            } else {
                System.out.println("Invalid input. Please select either one of - \"first\", \"second\".");
            }
        }
    }

    /*
     * 1. ააგეთ ჩათი, რომელიც დაჯდება 8080 პორტზე, მონაცემების მიმოცვლისათვის
     * მოახდინეთ მომხმარებლის IP-ის შეყვანა პროგრამის დასაწყისში. დაწერეთ პროგრამა
     * კლიენტის მხარეს, სერვერის მხარეს.
     * */
    private static void firstExercise() {
        Thread serverThread = new Thread(new dev.beriashvili.classwork.networking.chat.Server());
        serverThread.start();

        Thread clientThread = new Thread(new dev.beriashvili.classwork.networking.chat.Client());
        clientThread.start();
    }

    /*
     * 2. ააგეთ რომელიც მოუსმენს 8081 პორტს და შესაბამისად დაამუშავებს შემდეგი ტიპის
     * ინფორმაციას:
     * კლიენტის ბრძანებები: help, date, name, error
     * შესაბამისად help - სერვერი გაუგზავნის info.txt ფაილში help ველში ჩაწერილ
     * ინფორმაციას შესაბამისად date – date ველში ჩაწერილ ინფორმაციას და ა.შ. ფაილში
     * ველები ერთმანეთისგან გამოყოფილია ოთხი ტირით „----“, დაწერეთ შესაბამისი
     * info.txt ფაილში ჩასაწერი პროგრამული კოდი (ცალკე კლასში);
     * */
    private static void secondExercise() {
        Thread serverThread = new Thread(new dev.beriashvili.classwork.networking.consultant.Server());
        serverThread.start();

        Thread clientThread = new Thread(new dev.beriashvili.classwork.networking.consultant.Client());
        clientThread.start();
    }

    public static File getDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean makeDirectories = directory.mkdirs();

            if (makeDirectories) {
                System.out.println(String.format("Successfully created directory: %s", directory.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to create directory: %s", directory.getAbsolutePath()));
            }
        }

        return directory;
    }
}
