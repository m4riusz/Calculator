package com.calculator.util;

import java.util.Stack;

/**
 * Created by mariusz on 24.04.16.
 */
public interface PostfixNotation {

    public Stack<String> parse(String expression);

    public double evaluate(Stack<String> data);

}
