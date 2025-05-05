package com.bourkha.v2;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public static final int NUMBER_THRESHOLD = 1000;

    public int add(String expression) {
        if(StringUtils.isBlank(expression)) return 0;
        assertEndWithNewLine(expression);
        String[] split = getSplit(expression);
           assertContainsNegativeNumbers(split);
        return Arrays.stream(split)
                .map(String::strip)
                .map(Integer::parseInt)
                .filter(number -> number <= NUMBER_THRESHOLD)
                .reduce(Integer::sum)
                .orElseThrow();


    }

    private static String[] getSplit(String expression) {
        if(expression.startsWith("//")) {
            String[] split = multiDelimiterSplit(expression);
            if (ArrayUtils.isNotEmpty(split)) return multiDelimiterSplit(expression);

            String[] expressionToSplit = oneDelimiterSplit(expression);
            if (ArrayUtils.isNotEmpty(expressionToSplit)) return expressionToSplit;
        }

        return expression.split("[,\n]+");
    }

    private static String[] oneDelimiterSplit(String expression) {
        Matcher simpleDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if(simpleDelimiterMatcher.matches()) {
                String delimiter = simpleDelimiterMatcher.group(1);
                String expressionToSplit = simpleDelimiterMatcher.group(2);
            return expressionToSplit.split("[" + delimiter + " \n]+");
            }
        return  new String[]{};
    }

    private static String[] multiDelimiterSplit(String expression) {
        Matcher matcher = Pattern.compile("//(\\[([^w]+)\\]+)\n(.*)").matcher(expression);
        if(matcher.matches()) {
            String expressionToSplit = "";
            String delimiter = "";
            delimiter = matcher.group(1).replaceAll("[\\[\\]]", "");
            expressionToSplit = matcher.group(3);
            return expressionToSplit.split("[" + delimiter + "\n]+");
        }
        return new String[]{};
    }

    private String[] assertContainsNegativeNumbers(String[] split) {
        String negativeNumber = negativeNumber(split);
        if(StringUtils.isNotBlank(negativeNumber)) {
            throw new IllegalArgumentException("negatives not allowed : "+ negativeNumber);
        }
        return split;
    }

    private static void assertEndWithNewLine(String expression) {
        if(expression.endsWith("\n"))
            throw new IllegalArgumentException("the expression end with new line");
    }

    private String negativeNumber(String[] splitedExpression) {
        return Arrays.stream(splitedExpression)
                .map(String::strip)
                .filter(number -> StringUtils.contains(number,'-'))
                .collect(Collectors.joining(" "));
    }
}
