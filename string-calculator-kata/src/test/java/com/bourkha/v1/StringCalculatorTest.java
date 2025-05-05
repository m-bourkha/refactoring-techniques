package com.bourkha.v1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

/**
 * when method source of parmetrized test is an an instance method not static method :
 @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 */
class StringCalculatorTest {

    public static final String SEPARATORS = "[,\n]+";
    private StringCalculator stringCalculator ;


    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @MethodSource("validTests")
    void test_valid_cases(String expression, Integer res) {
        stringCalculator = new StringCalculator(expression);
        assertThat(stringCalculator.add()).isEqualTo(res);
    }

    @Test
    @DisplayName("Invalid format number or separator")
    void given_invalid_number_then_exception() {
        /*assertThatThrownBy( () -> stringCalculator.add("a,2"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"a\"");*/
        stringCalculator = new StringCalculator("a,2");

        assertThrows(NumberFormatException.class, () -> stringCalculator.add());
    }

    @Test
    void given_string_end_return_line_then_exception() {
        assertThatThrownBy(() -> new StringCalculator("1,3,\n"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Disabled
    void given_invalid_separator_then_exception() {
        stringCalculator = new StringCalculator("a;2");
        assertThatThrownBy(() -> stringCalculator.add())
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"a;2\"");
    }

    @Test
    void when_expression_contains_negative_then_exception() {
        stringCalculator = new StringCalculator("2,-1,-3");
        assertThatThrownBy(() -> stringCalculator.add())
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("negatives not allowed : -1 -3");
    }

    static Stream<Arguments> validTests() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(" 1", 1),
                Arguments.of("1 ,2",3),
                Arguments.of("1,2,4",7),
                Arguments.of("1\n2,4",7),
                Arguments.of("//;\n1;2",3),
                Arguments.of("//;\n1;1001",1),
                Arguments.of("//;\n1;1000",1001),
                Arguments.of("//[***]\n1***2***3",6),
                Arguments.of("//[****][%%]\n1****2%%3",6)
        );
    }
}