package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 16.03.16.
 */
public class Sinus extends Operator {

    public Sinus(int priority, boolean singleOperator) {
        super(priority, singleOperator);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {
        return Math.sin(numberOne);
    }
}
