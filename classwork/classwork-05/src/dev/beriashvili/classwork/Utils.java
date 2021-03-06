package dev.beriashvili.classwork;

import dev.beriashvili.classwork.file_operations.FileWriterOperations;
import dev.beriashvili.classwork.file_operations.MathematicalFunctions;
import dev.beriashvili.classwork.numeral_systems.BinaryFromDecimal;
import dev.beriashvili.classwork.numeral_systems.DecimalFromBinary;
import dev.beriashvili.classwork.percentages.CompoundPercentage;
import dev.beriashvili.classwork.percentages.SimplePercentage;

import java.util.Scanner;

class Utils {
    static void main() {
        FileWriterOperations fileWriterOperations = new FileWriterOperations();
        fileWriterOperations.main();

        MathematicalFunctions mathematicalFunctions = new MathematicalFunctions();
        mathematicalFunctions.main();

        BinaryFromDecimal binaryFromDecimal = new BinaryFromDecimal();
        int decimal = getDecimal();
        System.out.println(String.format("Decimal number %d to binary is: %s", decimal, binaryFromDecimal.convertFromDecimal(decimal)));

        DecimalFromBinary decimalFromBinary = new DecimalFromBinary();
        String binary = getBinary();
        System.out.println(String.format("Binary number %s to decimal is: %d", binary, decimalFromBinary.convertFromBinary(binary)));

        SimplePercentage simplePercentage = new SimplePercentage();
        System.out.println(simplePercentage.getPercentage(1_000, 5, 500));

        CompoundPercentage compoundPercentage = new CompoundPercentage();
        System.out.println(compoundPercentage.getPercentage(1_000, 5, 500));
    }

    private static int getDecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");

        return scanner.nextInt();
    }

    private static String getBinary() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");

        return scanner.nextLine();
    }
}
