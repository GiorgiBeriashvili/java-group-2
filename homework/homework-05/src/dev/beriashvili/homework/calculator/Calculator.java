package dev.beriashvili.homework.calculator;

import java.text.DecimalFormat;
import java.util.Queue;

public class Calculator {
    /*
     * კალკულატორი (3 ქულა)
     * კონსოლური აპლიკაცია, რომელიც შეძლებს შეტანილი ტექსტის დაპარსვას (სტრინგის ანალიზს)
     * და სწორი მათემატიკური მოქმედებების შესრულებას.
     * მაგალითად:
     * შეგვაქვს ტექსტი: 2+32 აპლიკაცია დაწერს პასუხს 34,
     * შეგვაქვს ტექსტი: 2*(2+32) აპლიკაცია დაწერს პასუხს 78,
     * შეგვაქვს ტექსტი 3+7^2*3/(43-12) აპლიკაციამ დაწერს პასუხს 7.742
     * პასუხებს პროგრამა ჩაწერს file.txt ფაილში თარიღის მითითებით.
     * */
    DecimalFormat decimalFormat = new DecimalFormat("0.###");
    String calculation;
    String mathematicalExpression;
    String infixNotation;
    Queue<String> postfixNotation;
    String[] tokens;
    Double result;

    public void calculate(String mathematicalExpression) {
        this.mathematicalExpression = mathematicalExpression;

        infixNotation = MathematicalExpressionFormatter.format(mathematicalExpression);
        postfixNotation = OperatorPrecedenceParser.parse(infixNotation);

        tokens = postfixNotation.toArray(new String[]{});
        result = PostfixNotation.evaluate(tokens);

        calculation = String.format("%s = %s", infixNotation, decimalFormat.format(result));

        System.out.println(calculation);
        CalculationStorer.store(calculation);
    }
}