package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 18.03.16.
 */
public class Cosinus extends Operator {

    public Cosinus(int priority, boolean singleOperator) {
        super(priority, singleOperator);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {
        return Math.cos(numberOne);
    }
}
