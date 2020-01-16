package com.github.mnestor0.java.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSumOfNonAdjacentNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void test(int[] arrayInput, int expectedResult) {
        MaxSumOfNonAdjacentNumbers max = new MaxSumOfNonAdjacentNumbers();
        assertEquals(expectedResult, expectedResult, max.find(arrayInput));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{2, 1}, 2),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{1, 3, 2}, 3),
                Arguments.of(new int[]{3, 2, 1}, 4),
                Arguments.of(new int[] {5, 1, 1, 5}, 10),
                Arguments.of(new int[] {2, 4, 6, 2, 5}, 13)
        );
    }

}