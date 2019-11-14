package com.github.mnestor0.java.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfNaturalNumbersTest {

    @ParameterizedTest
    @MethodSource("testValues")
    void sumTest(int n, int expectedSum) {
        int actualSum = SumOfNaturalNumbers.sum(n);
        assertEquals(expectedSum, actualSum);
    }

    static Stream<Arguments> testValues() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(3, 6),
                Arguments.of(4, 10),
                Arguments.of(5, 15),
                Arguments.of(6, 21)
        );
    }
}
