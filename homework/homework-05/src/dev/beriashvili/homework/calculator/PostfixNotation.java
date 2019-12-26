package dev.beriashvili.homework.calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class PostfixNotation {
    static Double calculate(Double leftOperand, Double rightOperand, String operator) {
        if ("+".equals(operator)) {
            return leftOperand + rightOperand;
        }

        if ("-".equals(operator)) {
            return leftOperand - rightOperand;
        }

        if ("*".equals(operator)) {
            return leftOperand * rightOperand;
        }

        if ("/".equals(operator)) {
            return leftOperand / rightOperand;
        }

        if ("^".equals(operator)) {
            return Math.pow(leftOperand, rightOperand);
        }

        throw new IllegalArgumentException("Invalid input.");
    }

    static Double evaluate(String[] tokens) {
        Stack<Double> stack = new Stack<>();

        Set<String> operators = new HashSet<>() {{
            addAll(Arrays.asList("+", "-", "*", "/", "^"));
        }};

        for (String token : tokens) {
            if (operators.contains(token)) {
                Double rightOperand = stack.pop();
                Double leftOperand = stack.pop();

                stack.push(calculate(leftOperand, rightOperand, token));
            } else {
                stack.push(Double.valueOf(token));
            }
        }

        return stack.pop();
    }
}