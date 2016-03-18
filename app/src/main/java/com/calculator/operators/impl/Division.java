package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 15.03.16.
 */
public class Division extends Operator {

    public Division(int priority) {
        super(priority);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {

        if (numberTwo == 0) {
            throw new IllegalArgumentException("You can't divide by 0!");
        }
        return numberOne / numberTwo;
    }
}
