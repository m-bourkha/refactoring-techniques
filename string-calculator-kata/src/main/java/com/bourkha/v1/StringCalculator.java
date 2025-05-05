package com.bourkha.v1;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StringCalculator {
    private final Expressions expressions;
    public StringCalculator(String expression) {
        this.expressions = new Expressions(expression);
    }

    public int add() {
        return expressions.sum();
    }


}
