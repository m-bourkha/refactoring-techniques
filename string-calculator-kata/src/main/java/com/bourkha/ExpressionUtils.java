package com.bourkha;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExpressionUtils {
    private ExpressionUtils() {
    }

    static List<Expression> buildExpressionLines(String expressions, List<Separator> separators) {
        String[] expressionLines = expressions.split("\n");

        return Arrays.stream(expressionLines).
                filter(expressionLine -> StringUtils.containsNone(expressionLine, "//"))
                .map(expressionLine -> new Expression(expressionLine, separators)).toList();
    }

    static List<Separator> buildSeparators(String expressions) {
        if (expressions.startsWith("//")) {
            if(isOneSeparator(expressions))  {
                return List.of(Separator.of(expressions.charAt(2)));
            }
            return getSeparators(expressions);
        }

        return List.of(Separator.DEFAULT);
    }

    private static boolean isOneSeparator(String expressions) {
        return StringUtils.containsNone(expressions, "[");
    }

    private static List<Separator> getSeparators(String expressions) {
        return IntStream.rangeClosed(2, expressions.lastIndexOf("]"))
                .filter(index -> expressions.charAt(index - 1) == '[')
                .mapToObj(index -> Separator.of(expressions.charAt(index)))
                .toList();
    }
}