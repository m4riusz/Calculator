package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 16.03.16.
 */
public class Exponentiation extends Operator {

    public Exponentiation(int priority) {
        super(priority);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {
        return Math.pow(numberOne, numberTwo);
    }
}
