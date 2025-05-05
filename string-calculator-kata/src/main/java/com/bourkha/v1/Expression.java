package com.bourkha.v1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Expression(String expression, List<Separator> separtors){
    private String[] splitNumbers() {
        return expression.split("[" + toString(separtors) + "]+");
    }

    private String toString(List<Separator> separtors) {
        return separtors.stream().map(separator -> "" + separator.getName()).collect(Collectors.joining());
    }

    public List<Integer> extractNumbers() {

    return Arrays.stream(splitNumbers())
            .filter(this::isValid)
            .map(String::strip)
            .map(Integer::parseInt)
            .toList();
}

boolean isValid(String number) {
    try {
        Integer.parseInt(number.strip());
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

Stream<Integer> negativeNumbers() {
    return extractNumbers().stream()
            .filter(number -> number < 0);
}

private List<Integer> validNumber() {
    return extractNumbers().stream()
            .filter(number -> number <= 1000)
            .toList();
}

Stream<String> invalidNumbers() {
    return Arrays.stream(splitNumbers())
            .filter(Predicate.not(this::isValid));
}

int sum() {
        return validNumber().stream().reduce(0, Integer::sum);
}
}
