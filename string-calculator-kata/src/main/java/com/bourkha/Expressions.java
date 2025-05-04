package com.bourkha;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Expressions {
    private final List<Expression> expressionList;

    public Expressions(String expressionList) {
        assertNotEndsWithReturnLine(expressionList);
        List<Separator> separators = ExpressionUtils.buildSeparators(expressionList);
        this.expressionList = ExpressionUtils.buildExpressionLines(expressionList, separators);
    }


    int sum() {
        assertNumbersValid();
        return this.expressionList.stream().map(Expression::sum).reduce(0, Integer::sum);
    }

    private void assertNumbersValid() {
        assertNumbersFormat();
        assertNegativeNumbers();
    }

    private List<String> invalidNumbers() {
        return expressionList.stream().flatMap(Expression::invalidNumbers).toList();
    }

    private List<Integer> negativeNumbers() {
       return expressionList.stream().flatMap(Expression::negativeNumbers).toList();
    }

    private void assertNotEndsWithReturnLine(String expressions) {
        if (expressions.endsWith("\n")) throw new IllegalArgumentException("String ends with return to new line");
    }

    void assertNegativeNumbers() {
        String negativeNumbers = negativeNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        if (StringUtils.isNotBlank(negativeNumbers))
            throw new NumberFormatException("negatives not allowed : " + negativeNumbers);
    }

    void assertNumbersFormat() {
        String invalidNumbers = String.join(" ", invalidNumbers());
        if (StringUtils.isNotEmpty(invalidNumbers)) {
            throw new NumberFormatException("the following numbrers are not valid : " + invalidNumbers);
        }
    }
}
