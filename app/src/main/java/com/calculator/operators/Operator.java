package com.calculator.operators;

/**
 * Created by mariusz on 15.03.16.
 */
public abstract class Operator implements Executable {
    private int priority;
    private boolean singleOperator;

    public Operator() {
        priority = 0;
        singleOperator = false;
    }

    public Operator(int priority, boolean singleOperator) {
        this.priority = priority;
        this.singleOperator = singleOperator;
    }

    public Operator(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSingleOperator() {
        return singleOperator;
    }
}
