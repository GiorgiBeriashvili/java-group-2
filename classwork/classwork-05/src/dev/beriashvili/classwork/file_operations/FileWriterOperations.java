package dev.beriashvili.classwork.file_operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FileWriterOperations implements Operations {
    public void main() {
        writePredeterminedIntegersToFile(new int[]{24, 39, -90}, "data.txt", false);
        writeIntegersFromRangeToFile(0, 100, "data1.txt", true);
        writeStringIntoMultipleFiles(1, 30, false);
        writeIndexedStringIntoMultipleFiles(1, 30, false);
        writeRandomIntegersToFile(100, "data2.txt", true);
        writeRandomRealNumbersToFile(50, "data3.txt", true);
        writeIntegersIntoMultipleFiles(1, 10_000, false);
        writeToTwoSeparateFilesUsingInterestingOperations("numbers.txt", "numbers2.txt", 40, true);
        writeMatrixToFile("info.txt", true);
    }

    static File getDirectory(String directoryPath) {
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

    /*
     * მთელი 24, 39, -90 რიცხვები ჩაწერეთ data.txt ფაილში, ფაილი შექმენით myFiles
     * საქაღალდეში.
     * */
    @Override
    public void writePredeterminedIntegersToFile(int[] integers, String fileName, boolean append) {
        File directory = getDirectory("data/myFiles");
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));

        try {
            FileWriter fileWriter = new FileWriter(file, append);

            fileWriter.write(Arrays.toString(integers).substring(1, Arrays.toString(integers).length() - 1));

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*
     * 0-დან 100-მდე მთელი რიცხვები ჩაწერეთ data1.txt ფაილში. myFiles საქაღალდეში.
     * */
    @Override
    public void writeIntegersFromRangeToFile(int minimumBound, int maximumBound, String fileName, boolean append) {
        File directory = getDirectory("data/myFiles");
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file, append);

            for (int integer = minimumBound; integer < maximumBound; integer++) {
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
    @Override
    public void writeStringIntoMultipleFiles(int minimumBound, int maximumBound, boolean append) {
        File directory = getDirectory("data/myFiles1");

        for (int fileIndex = minimumBound; fileIndex <= maximumBound; fileIndex++) {
            try {
                File file = new File(String.format("%s/%s", directory.getPath(), fileIndex));

                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write("Programmer");

                fileWriter.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /*
     * myFiles2 საქაღალდეში საქაღალდეში შექმენით 30 ფაილი, ფაილებში ჩაწერეთ სიტყვები
     * „Programmer1“, „Programmer2“ .... „Programmer30“.
     * */
    @Override
    public void writeIndexedStringIntoMultipleFiles(int minimumBound, int maximumBound, boolean append) {
        File directory = getDirectory("data/myFiles2");

        for (int fileIndex = minimumBound; fileIndex <= maximumBound; fileIndex++) {
            try {
                File file = new File(String.format("%s/%s", directory.getPath(), fileIndex));

                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write(String.format("Programmer%s", fileIndex));

                fileWriter.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /*
     * კლავიატურიდან გადაცემული [a, b] შუალედიდან ჩაწერეთ data2.txt ფაილში 100
     * შემთხვევითი მთელი რიცხვი. ფაილი შექმენით myFiles საქაღალდეში.
     * */
    @Override
    public void writeRandomIntegersToFile(int integerCount, String fileName, boolean append) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        int minimumBound = Math.min(a, b);
        int maximumBound = Math.max(a, b);

        File directory = getDirectory("data/myFiles");
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));
        Random random = new Random();

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        for (int index = 0; index < integerCount; index++) {
            int randomInteger = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;

            try {
                FileWriter fileWriter = new FileWriter(file, append);

                fileWriter.write(String.format("%d\n", randomInteger));

                fileWriter.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /*
     * კლავიატურიდან გადაცემული [a, b] შუალედიდან დაამატეთ data3.txt ფაილში 50
     * შემთხვევითი ნამდვილი რიცხვი. დამატებული რიცხვები გამოყავით მასში არსებული
     * რიცხვებიდან. myFiles საქაღალდეში.
     * */
    @Override
    public void writeRandomRealNumbersToFile(int realNumberCount, String fileName, boolean append) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        int minimumBound = Math.min(a, b);
        int maximumBound = Math.max(a, b);

        File directory = getDirectory("data/myFiles");
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));
        Random random = new Random();

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        for (int index = 0; index < realNumberCount; index++) {
            double randomRealNumber = minimumBound + (maximumBound - minimumBound) * random.nextDouble();

            try {
                FileWriter fileWriter = new FileWriter(file, append);

                fileWriter.write(String.format("%f\n", randomRealNumber));

                fileWriter.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /*
     * დაწერეთ ფუნქცია, რომელიც ჩაწერს 10 000-ს ‘.txt’ გაფართოების ფაილს myFiles
     * საქაღალდეში, ფაილებში ჩაწერს 1-დან 10 000-მდე რიცხვებს და შესაბამისად ფაილის
     * სახელი იქნება ის რიცხვი რაც ჩაწერილია შესაბამის ფაილში. მაგ(თუ ფაილში ჩაწერილია
     * რიცხვი 12 მაშინ ამ ფაილის სახელი იქნება 12.txt).
     * */
    @Override
    public void writeIntegersIntoMultipleFiles(int minimumBound, int maximumBound, boolean append) {
        File directory = getDirectory("data/myFiles");

        for (int fileIndex = minimumBound; fileIndex < maximumBound; fileIndex++) {
            try {
                File file = new File(String.format("%s/%s", directory.getPath(), fileIndex));

                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write(String.format("%s", fileIndex));

                fileWriter.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /*
     * შეიტანეთ ორი a და b რიცხვები, ჩაწერეთ numbers.txt ფაილში ამ რიცხვებს შორის
     * მოთავსებული 40 მთელი რიცხვი, დაადგინეთ რამდენია ლუწი და რამდენი კენტი
     * ფაილში ჩაწერილ რიცხვებს შორის, მოახდინეთ ლუწი რიცხვებისა და კენტი რიცხვების
     * ჯამის გამოტანა ეკრანზე და მიღებულ ჯამებს შორის 5 შემთხვევითი რიცხვი ჩაწეროთ
     * ფაილში numbers2.txt ფაილში.
     * */
    @Override
    public void writeToTwoSeparateFilesUsingInterestingOperations(String firstFileName, String secondFileName, int integerCount, boolean append) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        File directory = getDirectory("data/numbers");
        File file = new File(String.format("%s/%s", directory.getPath(), firstFileName));

        int minimumBound = Math.min(a, b);
        int maximumBound = Math.max(a, b);

        int evenIntegerCount = 0;
        int oddIntegerCount = 0;

        int evenIntegerSum = 0;
        int oddIntegerSum = 0;

        Random random = new Random();

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file, append);

            for (int index = 0; index < integerCount; index++) {
                int randomInteger = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;

                if ((randomInteger & 1) == 0) {
                    evenIntegerCount++;
                    evenIntegerSum += randomInteger;
                } else {
                    oddIntegerCount++;
                    oddIntegerSum += randomInteger;
                }

                fileWriter.write(String.format("%d\n", randomInteger));
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }

        System.out.println(String.format("Count of even integers: %d", evenIntegerCount));
        System.out.println(String.format("Count of odd integers: %d", oddIntegerCount));

        System.out.println(String.format("Sum of even integers: %d", evenIntegerSum));
        System.out.println(String.format("Sum of odd integers: %d", oddIntegerSum));

        file = new File(String.format("%s/%s", directory.getPath(), secondFileName));

        minimumBound = Math.min(evenIntegerSum, oddIntegerSum);
        maximumBound = Math.max(evenIntegerSum, oddIntegerSum);

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file, append);

            for (int index = 0; index < integerCount - 35; index++) {
                int randomInteger = random.nextInt(maximumBound - minimumBound + 1) + minimumBound;

                fileWriter.write(String.format("%d\n", randomInteger));
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*
     * კლავიატურიდან შეტანილი m<=50 და n<=50 ნატურალური რიცხვების მიხედვით. info.txt
     * ფაილში ჩაწერეთ შემთხვევითი 1 ან 0 ციფრები m სტრიქონში და n სვეტში. მოახდინეთ
     * info.txt ფაილის წაკითხვა, დაითვალეთ რამდენი 1 და რამდენი 1 სიმბოლოა ჩაწერილი
     * ფაილში.
     * */
    @Override
    public void writeMatrixToFile(String fileName, boolean append) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of m (rows, maximum: 50): ");
        int m = scanner.nextInt();

        if (m > 50) {
            m = 50;
        }

        System.out.print("Enter the value of n (columns, maximum: 50): ");
        int n = scanner.nextInt();

        if (n > 50) {
            n = 50;
        }

        File directory = getDirectory("data/numbers");
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));

        int[][] matrix = new int[m][n];

        int onesCount = 0;

        Random random = new Random();

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, append));

            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    int randomValue = random.nextInt(2);

                    matrix[row][column] = randomValue;

                    if (randomValue == 1) {
                        onesCount++;
                    }

                    if (column == matrix[row].length - 1) {
                        fileWriter.write(String.valueOf(matrix[row][column]));
                    } else {
                        fileWriter.write(matrix[row][column] + " ");
                    }
                }

                fileWriter.newLine();
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }

        System.out.println(String.format("There are %d ones in the matrix.", onesCount));
    }
}
