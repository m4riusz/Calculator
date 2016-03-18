package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 18.03.16.
 */
public class Tangens extends Operator {

    public Tangens(int priority, boolean singleOperator) {
        super(priority, singleOperator);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {
        return Math.tan(numberOne);
    }
}
