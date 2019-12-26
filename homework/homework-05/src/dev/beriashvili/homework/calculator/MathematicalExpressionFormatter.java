package dev.beriashvili.homework.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MathematicalExpressionFormatter {
    static char startingOperator;
    static boolean validExpression = true;
    static boolean startsWithOperator;
    static String characterValidator = "[^\\d+\\-*/^()]+";
    static String validator = "(\\d+|[+\\-/*^()])";

    static String format(String mathematicalExpression) {
        StringBuilder stringBuilder = new StringBuilder();

        mathematicalExpression = mathematicalExpression.strip().replace(" ", "");

        for (int index = 0; index < mathematicalExpression.length(); index++) {
            if (Pattern.matches(characterValidator, String.valueOf(mathematicalExpression.charAt(index)))) {
                try {
                    validExpression = false;

                    throw new Exception(String.format("Illegal character detected... could not calculate %s.", mathematicalExpression));
                } catch (Exception error) {
                    System.out.println(error.getMessage());
                }
            }
        }

        if (!validExpression) {
            System.exit(1);
        }

        startingOperator = mathematicalExpression.charAt(0);

        if (startingOperator == '+' || startingOperator == '-') {
            mathematicalExpression = mathematicalExpression.substring(1);

            startsWithOperator = true;
        }

        Pattern pattern = Pattern.compile(validator);
        Matcher matcher = pattern.matcher(mathematicalExpression);

        if (startsWithOperator && startingOperator == '-') {
            stringBuilder.append('-');
        }

        while (matcher.find()) {
            stringBuilder.append(String.format("%s ", matcher.group()));
        }

        return stringBuilder.toString().strip();
    }
}
