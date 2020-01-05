package com.github.mnestor0.java.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMissingNaturalTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void findProductTest(int[] arrayInput, int expectedResult) {
        FindMissingNatural find = new FindMissingNatural();
        assertEquals(expectedResult, find.find(arrayInput), Arrays.toString(arrayInput));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{}, 1),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{2}, 1),
                Arguments.of(new int[]{1}, 2),
                Arguments.of(new int[]{2, 1}, 3),
                Arguments.of(new int[]{2, 3, 1}, 4),
                Arguments.of(new int[]{3, 4, -1, 1}, 2),
                Arguments.of(new int[]{2, -1, 1, -1, 3}, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 10),
                Arguments.of(new int[]{4, 5, 6, 4, 8, 9, 1, 2, 3}, 7)
        );
    }
}