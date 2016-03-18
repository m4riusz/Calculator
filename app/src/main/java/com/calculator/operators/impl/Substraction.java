package com.calculator.operators.impl;

import com.calculator.operators.Operator;

/**
 * Created by mariusz on 15.03.16.
 */
public class Substraction extends Operator {

    public Substraction(int priority) {
        super(priority);
    }

    @Override
    public double execute(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }
}
