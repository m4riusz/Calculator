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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mariusz on 15.03.16.
 */
public class Calc {

    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final Map<String, Operator> OPERATORS_MAP = createMap();
    public static final String DOT = ".";
    private static final int PRIORITY_LOW = 1;
    private static final int PRIORITY_MED = 2;
    private static final int PRIORITY_HIGH = 3;
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLE = "*";
    public static final String DIVIDE = "/";
    public static final String POW = "^";
    public static final String SQRT = "√";
    public static final String SIN = "sin";
    public static final String COS = "cos";
    public static final String TAN = "tan";
    public static final String LN = "ln";
    public static final String LOG = "log";

    private static Map<String, Operator> createMap() {
        Map<String, Operator> result = new HashMap<>();
        result.put(PLUS, new Addition(PRIORITY_LOW));
        result.put(MINUS, new Substraction(PRIORITY_LOW));
        result.put(MULTIPLE, new Multiplication(PRIORITY_MED));
        result.put(DIVIDE, new Division(PRIORITY_MED));
        result.put(POW, new Exponentiation(PRIORITY_HIGH));
        result.put(SQRT, new Root(PRIORITY_HIGH, true));
        result.put(SIN, new Sinus(PRIORITY_HIGH, true));
        result.put(COS, new Cosinus(PRIORITY_HIGH, true));
        result.put(TAN, new Tangens(PRIORITY_HIGH, true));
        result.put(LN, new NaturalLogarithm(PRIORITY_HIGH, true));
        result.put(LOG, new Logarithm(PRIORITY_HIGH, true));
        return result;
    }

    public static List<String> OPERATORS_WITH_BRACKETS = operatorsWithBrackets();

    private static List<String> operatorsWithBrackets() {
        List<String> list = new ArrayList<>();
        list.add(SIN);
        list.add(COS);
        list.add(TAN);
        list.add(LN);
        list.add(LOG);
        return list;
    }

}
