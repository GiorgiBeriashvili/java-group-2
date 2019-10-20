package dev.beriashvili.classwork.file_operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MathematicalFunctions {
    public void main() {
        functionOne();
        functionTwo();
    }

    /*
     * დაწერეთ პროგრამა, რომელიც y = x^3 + e^x ფუნქციის მნიშვნელობებს დაითვლის [0; 2 ]
     * შუალედში მეასედების სიზუსტით და შესაბამის მნიშვნელობებს ჩაწერს function.txt
     * ფაილში myFiles საქაღალდეში.
     * */
    private void functionOne() {
        File directory = FileWriterOperations.getDirectory("data/myFiles");
        File file = new File(String.format("%s/%s", directory.getPath(), "function.txt"));

        double x, y, e = Math.E, minimumBound = 0.0, maximumBound = 2.0;

        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file, true);

            fileWriter.write("f(x) = x^3 + e^x\n\n");

            for (x = minimumBound; x <= maximumBound + 0.01; x += 0.01) {
                y = Math.pow(x, 3) + Math.pow(e, x);

                fileWriter.write(String.format("f(%.2f) = %f\n", x, y));
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /*
     * დაწერეთ პროგრამა, რომელიც y = sin(x) + e^x + 1 ფუნქციის მნიშვნელობებს დაითვლის
     * [0; 2 ] შუალედში მეასედების სიზუსტით და შესაბამის მნიშვნელობებს ჩაწერს function.txt
     * ფაილში.
     * */
    private void functionTwo() {
        File directory = FileWriterOperations.getDirectory("data/myFiles");
        File file = new File(String.format("%s/%s", directory.getPath(), "function.txt"));

        double x, y, e = Math.E, minimumBound = 0.0, maximumBound = 2.0;

        try {
            FileWriter fileWriter = new FileWriter(file, true);

            fileWriter.write("f(x) = sin(x) + e^x + 1\n\n");

            for (x = minimumBound; x <= maximumBound + 0.01; x += 0.01) {
                y = Math.sin(x) + Math.pow(e, x) + 1;

                fileWriter.write(String.format("f(%.2f) = %f\n", x, y));
            }

            fileWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
