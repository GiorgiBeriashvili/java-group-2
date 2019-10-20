package dev.beriashvili.classwork.file_operations;

public interface Operations {
    void writePredeterminedIntegersToFile(int[] integers, String fileName, boolean append);

    void writeIntegersFromRangeToFile(int minimumBound, int maximumBound, String fileName, boolean append);

    void writeStringIntoMultipleFiles(int minimumBound, int maximumBound, boolean append);

    void writeIndexedStringIntoMultipleFiles(int minimumBound, int maximumBound, boolean append);

    void writeRandomIntegersToFile(int integerCount, String fileName, boolean append);

    void writeRandomRealNumbersToFile(int realNumberCount, String fileName, boolean append);

    void writeIntegersIntoMultipleFiles(int minimumBound, int maximumBound, boolean append);

    void writeToTwoSeparateFilesUsingInterestingOperations(String firstFileName, String secondFileName, int integerCount, boolean append);

    void writeMatrixToFile(String fileName, boolean append);
}
