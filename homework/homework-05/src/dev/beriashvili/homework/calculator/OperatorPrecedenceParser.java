package dev.beriashvili.homework.calculator;

import java.util.*;

public class OperatorPrecedenceParser {
    /*
     * Implemented using Edsger Dijkstra's shunting-yard algorithm
     * */
    static Queue<String> infixNotation;

    static boolean isNumber(String token) {
        try {
            Double.valueOf(token);

            return true;
        } catch (Exception error) {
            return false;
        }
    }

    static Queue<String> infixToPostfix(String[] infixNotation) {
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("^", 6);
        precedence.put("/", 5);
        precedence.put("*", 5);
        precedence.put("+", 4);
        precedence.put("-", 4);
        precedence.put("(", 0);

        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (String token : infixNotation) {
            if ("(".equals(token)) {
                stack.push(token);

                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(stack.peek())) {
                    queue.add(stack.pop());
                }

                stack.pop();

                continue;
            }

            if (precedence.containsKey(token)) {
                while (!stack.empty() && precedence.get(token) <= precedence.get(stack.peek())) {
                    queue.add(stack.pop());
                }

                stack.push(token);

                continue;
            }

            if (isNumber(token)) {
                queue.add(token);

                continue;
            }

            throw new IllegalArgumentException("Invalid input.");
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    public static Queue<String> parse(String infixNotation) {
        try {
            OperatorPrecedenceParser.infixNotation = infixToPostfix(infixNotation.split(" "));

            return OperatorPrecedenceParser.infixNotation;
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        return OperatorPrecedenceParser.infixNotation;
    }
}
