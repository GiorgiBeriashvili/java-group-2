package dev.beriashvili.homework;

import dev.beriashvili.homework.calculator.Calculator;
import dev.beriashvili.homework.galaxy.Cosmos;

import java.io.File;

public class Utils {
    public static void main() {
        Calculator calculator = new Calculator();

        calculator.calculate("2+32");
        calculator.calculate("2*(2+32)");
        calculator.calculate("3+7^2*3/(43-12)");

        System.out.println();

        Cosmos cosmos = new Cosmos();
        cosmos.initialize();
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
