package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 16.03.16.
 */
public class Root extends Operator {

    public Root(int priority, boolean singleOperator) {
        super(priority, singleOperator);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {
        if (numberOne < 0) {
            throw new IllegalArgumentException("Root number cant be smaller than 0!");
        }
        return Math.sqrt(numberOne);
    }
}
