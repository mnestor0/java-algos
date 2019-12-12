package com.github.mnestor0.java.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BracesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void testBraces(String input, boolean expectedResult) {
        Braces braces = new Braces();
        assertEquals(expectedResult, braces.testBraces(input), "Expected " + input + " to result in " + expectedResult);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("(", false),
                Arguments.of("{", false),
                Arguments.of("[", false),
                Arguments.of(")", false),
                Arguments.of("}", false),
                Arguments.of("]", false),
                Arguments.of("(){", false),
                Arguments.of("]()", false),
                Arguments.of("{{}", false),
                Arguments.of("([)]", false),
                Arguments.of("((()", false),
                Arguments.of("([{", false),
                Arguments.of("}]]", false),
                Arguments.of("[()", false),
                Arguments.of("()", true),
                Arguments.of("{}", true),
                Arguments.of("[]", true),
                Arguments.of("([])[]({})", true),
                Arguments.of("[]{}(){([])}", true)
        );
    }
}
