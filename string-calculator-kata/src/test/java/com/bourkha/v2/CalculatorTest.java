package com.bourkha.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void should_return_zero_when_null_or_empty_string() {
        assertThat(calculator.add("")).isZero();
        assertThat(calculator.add(null)).isZero();
    }
    @Test
    void should_return_number_when_one_number() {
        assertThat(calculator.add("2 ")).isEqualTo(2);
    }
    @Test
    void should_return_sum_when_mutltiple_numbers() {
        assertThat(calculator.add("1 ,2 ,3")).isEqualTo(6);
    }

    @Test
    void should_throw_exception_when_ivalid_number_format() {
       assertThatThrownBy(() -> calculator.add("a, 3, 5")).isInstanceOf(NumberFormatException.class);
    }
    @Test
    void should_return_sum_when_new_line_delimiter() {
        assertThat(calculator.add("3\n4,5")).isEqualTo(12);
    }
    @Test
    void should_throw_exception_when_string_end_with_new_line() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("a,3,5,\n"), "the expression end with new line");
    }

    @Test
    void should_return_sum_when_new__delimiter() {
        assertThat(calculator.add("//;\n4;5")).isEqualTo(9);
    }
    @Test
    void should_throw_exception_for_negative_numbers() {
        assertThatThrownBy(() -> calculator.add("-1,2\n-3")).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("negatives not allowed : -1 -3");
    }


    @Test
    void should_ignore_number_bigger_than_one_thousand() {
        assertThat(calculator.add("1001,1")).isEqualTo(1);
    }
    @Test
    void should_return_sum_for_any_length_delimiter() {
        assertThat(calculator.add("//[***]\n1***2***3")).isEqualTo(6);
    }
    @Test
    void should_return_sum_for_multiple_delimiter_of_any_lenth() {
        assertThat(calculator.add("//[**][%%%]\n1**2%%%3")).isEqualTo(6);
    }
}