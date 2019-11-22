package dev.beriashvili.exam.exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryWriter {
    private int decimal;
    private String binary;

    public void main() {
        decimal = getInput();
        binary = decimalToBinary();
        writeToFile();
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal: ");
        decimal = scanner.nextInt();

        return decimal;
    }

    private String decimalToBinary() {
        StringBuilder binary = new StringBuilder();
        Stack<Integer> digits = new Stack<>();

        int origin = decimal;

        if (decimal >= 0) {
            binary.append("0 ");
        } else {
            binary.append("1 ");
        }

        decimal = Math.abs(decimal);

        while (this.decimal != 0) {
            int digit = decimal % 2;

            digits.push(digit);

            decimal /= 2;
        }

        while (!digits.empty()) {
            binary.append(digits.pop());
        }

        this.decimal = origin;

        return binary.toString();
    }

    private void writeToFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/number.txt", true));

            bufferedWriter.write(String.format("Decimal %d to binary: %s\n", this.decimal, this.binary));

            bufferedWriter.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
