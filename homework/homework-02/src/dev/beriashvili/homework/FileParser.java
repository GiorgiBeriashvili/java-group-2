package dev.beriashvili.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class FileParser {
    /*
     * 2. დაწერეთ პროგრამა, რომელიც function.txt ფაილიდან (იხილეთ ამოცანა 1)
     *    წაიკითხავს მონაცემებს და დაბეჭდავს მნიშვნელობებს შორის მინიმალურს და
     *    მაქსიმალურს.
     * */
    void main(String directoryPath, String fileName, int precision) {
        getData(directoryPath, fileName, precision);

        System.out.println(String.format("The minimum value of the function.txt real number results is: %f", getMinimumElement(getData(directoryPath, fileName, precision))));
        System.out.println(String.format("The maximum value of the function.txt real number results is: %f", getMaximumElement(getData(directoryPath, fileName, precision))));
    }

    private double[] getData(String directoryPath, String fileName, int precision) {
        File directory = Utils.getDirectory(directoryPath);
        File file = new File(String.format("%s/%s", directory.getPath(), fileName));

        double[] data = new double[precision + 1];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            int index = 0, lineIndex = 0;
            String line;

            while ((line = bufferedReader.readLine()) != null && index != precision + 1) {
                if (lineIndex >= 2) {
                    data[index] = Double.parseDouble(line.substring(line.lastIndexOf(" ") + 1));

                    index++;
                }

                lineIndex++;
            }

            bufferedReader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }

        return data;
    }

    private double iterateOverArray(double[] data, boolean isMinimum, double extrema) {
        if (isMinimum) {
            for (double datum : data) {
                if (datum < extrema) {
                    extrema = datum;
                }
            }
        } else {
            for (double datum : data) {
                if (datum > extrema) {
                    extrema = datum;
                }
            }
        }

        return extrema;
    }

    private double findMinimumOrMaximum(double[] data, boolean isMinimum) {
        double extrema;

        if (isMinimum) {
            extrema = iterateOverArray(data, true, Double.MAX_VALUE);
        } else {
            extrema = iterateOverArray(data, false, Double.MIN_VALUE);
        }

        return extrema;
    }

    private double getMinimumElement(double[] data) {
        return findMinimumOrMaximum(data, true);
    }

    private double getMaximumElement(double[] data) {
        return findMinimumOrMaximum(data, false);
    }
}
