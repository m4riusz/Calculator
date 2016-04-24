package com.calculator.util;

import com.calculator.operators.Operator;
import com.calculator.operators.impl.Addition;
import com.calculator.operators.impl.Cosinus;
import com.calculator.operators.impl.Division;
import com.calculator.operators.impl.Exponentiation;
import com.calculator.operators.impl.Logarithm;
import com.calculator.operators.impl.Multiplication;
import com.calculator.operators.impl.NaturalLogarithm;
import com.calculator.operators.impl.Root;
import com.calculator.operators.impl.Sinus;
import com.calculator.operators.impl.Substraction;
import com.calculator.operators.impl.Tangens;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariusz on 15.03.16.
 */
public class Calc {

    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final Map<String, Operator> OPERATORS_MAP = createMap();
    private static final int PRIORITY_LOW = 1;
    private static final int PRIORITY_MED = 2;
    private static final int PRIORITY_HIGH = 3;

    private static Map<String, Operator> createMap() {
        Map<String, Operator> result = new HashMap<>();
        result.put("+", new Addition(PRIORITY_LOW));
        result.put("-", new Substraction(PRIORITY_LOW));
        result.put("*", new Multiplication(PRIORITY_MED));
        result.put("/", new Division(PRIORITY_MED));
        result.put("^", new Exponentiation(PRIORITY_HIGH));
        result.put("√", new Root(PRIORITY_HIGH, true));
        result.put("sin", new Sinus(PRIORITY_HIGH, true));
        result.put("cos", new Cosinus(PRIORITY_HIGH, true));
        result.put("tan", new Tangens(PRIORITY_HIGH, true));
        result.put("ln", new NaturalLogarithm(PRIORITY_HIGH, true));
        result.put("log", new Logarithm(PRIORITY_HIGH, true));
        return result;
    }

}
