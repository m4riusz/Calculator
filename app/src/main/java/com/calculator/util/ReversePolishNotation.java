package com.calculator.util;

import com.calculator.operators.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by mariusz on 15.03.16.
 */
public class ReversePolishNotation {

    private Stack<String> output;
    private Stack<String> stack;

    public ReversePolishNotation() {
        output = new Stack<>();
        stack = new Stack<>();
    }

    public Stack<String> parse(String expression) {
        Stack<String> splittedExpression = reverseStack(splitExpression(expression));
        while (!splittedExpression.empty()) {
            String value = splittedExpression.pop();
            if (isNumber(value)) {
                output.push(value);
            } else if (value.equals(Calc.LEFT_BRACKET)) {
                stack.push(value);
            } else if (value.equals(Calc.RIGHT_BRACKET)) {
                clearStackToLeftBracket();
            } else if (isOperator(value)) {
                fillOperatorByPriority(value);
            }
        }
        appendRestOperators();
        return output;
    }

    public double evaluate(Stack<String> data) {
        Stack<String> reverseData = reverseStack(data);
        Stack<String> workingData = new Stack<>();

        while (!reverseData.empty()) {
            String value = reverseData.pop();
            if (isNumber(value)) {
                workingData.push(value);
            } else if (isOperator(value)) {
                double result = 0;
                Operator operator = Calc.OPERATORS_MAP.get(value);
                if (operator.isSingleOperator()) {
                    double numberOne = Double.parseDouble(workingData.pop());
                    result = Calc.OPERATORS_MAP.get(value).execute(numberOne, 0);
                } else {
                    double numberTwo = Double.parseDouble(workingData.pop());
                    double numberOne = Double.parseDouble(workingData.pop());
                    result = Calc.OPERATORS_MAP.get(value).execute(numberOne, numberTwo);
                }
                workingData.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(workingData.pop());
    }

    private Stack<String> splitExpression(String expression) {
        String split[] = expression.split(Calc.SPLIT_MATH_EXPRESSION);
        List<String> splitResult = new ArrayList<String>(Arrays.asList(split));
        String previousSymbol = "";

        Stack<String> fixedSplitResult = new Stack<>();
        for (String str : splitResult) {
            if (isNumber(str) && str.startsWith("-") && (isNumber(previousSymbol) || previousSymbol.equals(Calc.RIGHT_BRACKET))) {
                fixedSplitResult.push("-");
                fixedSplitResult.push(str.substring(1));
                previousSymbol = str.substring(1);
                continue;
            }
            previousSymbol = str;
            fixedSplitResult.push(str);
        }
        return fixedSplitResult;
    }

    private Stack<String> reverseStack(Stack<String> stackToReverse) {
        Stack<String> reversedData = new Stack<>();
        while (!stackToReverse.empty()) {
            reversedData.push(stackToReverse.pop());
        }
        return reversedData;
    }

    private boolean isNumber(String symbol) {
        try {
            double number = Double.parseDouble(symbol);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String symbol) {
        return Calc.OPERATORS_MAP.containsKey(symbol);
    }

    private void appendRestOperators() {
        while (!stack.empty()) {
            output.push(stack.pop());
        }
    }

    private void fillOperatorByPriority(String symbol) {
        while (!stack.empty() && getPriority(stack.peek()) >= getPriority(symbol)) {
            output.push(stack.pop());
        }
        stack.push(symbol);
    }

    private void clearStackToLeftBracket() {
        while (!stack.peek().equals(Calc.LEFT_BRACKET)) {
            output.push(stack.pop());
        }
        stack.pop();
    }

    private int getPriority(String operator) {
        if (Calc.OPERATORS_MAP.containsKey(operator)) {
            return Calc.OPERATORS_MAP.get(operator).getPriority();
        } else {
            return 0;
        }
    }

}
