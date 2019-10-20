package dev.beriashvili.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class MathematicalFunction {
    /*
     * 1. დაწერეთ პროგრამა, რომელიც y = x^2 + 2x + 3 ფუნქციის მნიშვნელობებს დაით-
     *    ვლის [1; 2 ] შუალედში მეასედების სიზუსტით და შესაბამის მნიშვნელობებს
     *    ჩაწერს function.txt ფაილში.
     * */
    void main(String directoryPath, String fileName, double precision) {
        writeToFile(directoryPath, fileName, 1, 2, 1 / precision, true);
    }

    private double getFunctionOutput(double x) {
        return Math.pow(x, 2) + 2 * x + 3;
    }

    private void writeToFile(String directoryPath, String fileName, int minimumBound, int maximumBound, double iterationStep, boolean append) {
        File directory = Utils.getDirectory(directoryPath);
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));

        Utils.deleteExistingFile(file);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append));

            bufferedWriter.write("f(x) = x^2 + 2x + 3\n\n");

            for (double iteration = minimumBound; iteration <= maximumBound + iterationStep; iteration += iterationStep) {
                bufferedWriter.write(String.format("f(%.2f) = %.4f\n", iteration, getFunctionOutput(iteration)));
            }

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
