package com.github.mnestor0.java.sort;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData {

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Integer[0], new Integer[0]),
                Arguments.of(new Integer[] {1}, new Integer[] {1}),
                Arguments.of(new Integer[] {1, 2}, new Integer[] {1, 2}),
                Arguments.of(new Integer[] {2, 1}, new Integer[] {1, 2}),
                Arguments.of(new Integer[] {1, 2, 3}, new Integer[] {1, 2, 3}),
                Arguments.of(new Integer[] {3, 2, 1}, new Integer[] {1, 2 ,3}),
                Arguments.of(new Integer[] {3, 2, 1, 2, 3}, new Integer[] {1, 2, 2, 3, 3}),
                Arguments.of(new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10})
        );
    }
}
