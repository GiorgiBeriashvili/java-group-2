package dev.beriashvili.homework;

import java.io.File;

class Utils {
    static void main(String directoryPath, String fileName, int precision) {
        // 1.
        MathematicalFunction mathematicalFunction = new MathematicalFunction();
        mathematicalFunction.main(directoryPath, fileName, precision);

        // 2.
        FileParser fileParser = new FileParser();
        fileParser.main(directoryPath, fileName, precision);

        // 3.
        NumericalOperations numericalOperations = new NumericalOperations(6, 12);
        numericalOperations.main();
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

    static void deleteExistingFile(File file) {
        if (file.exists()) {
            boolean fileDeletion = file.delete();

            if (fileDeletion) {
                System.out.println(String.format("Successfully deleted file: %s", file.getAbsolutePath()));
            } else {
                System.out.println(String.format("Failed to delete non-existing file: %s", file.getAbsolutePath()));
            }
        }
    }
}
