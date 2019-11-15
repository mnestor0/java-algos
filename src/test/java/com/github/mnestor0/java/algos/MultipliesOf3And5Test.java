package com.github.mnestor0.java.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MultipliesOf3And5Test {

    @ParameterizedTest
    @MethodSource("testData")
    void testAlgorithm(int limit, int expectedOutcome) {
        assertEquals(expectedOutcome, MultipliesOf3And5.multiplies(limit));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(3, 0),
                Arguments.of(6, 8),
                Arguments.of(10, 23),
                Arguments.of(1000, 233168)
        );
    }
}
