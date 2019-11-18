package com.github.mnestor0.java.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("testData")
    void testSort(List<Integer> toBeSorted, List<Integer> expectedList) {
        Integer[] arrayToBeSorted = toBeSorted.toArray(new Integer[0]);
        Integer[] expectedArray = expectedList.toArray(new Integer[0]);
        new SelectionSort<Integer>().sort(arrayToBeSorted);
        assertArrayEquals(expectedArray, arrayToBeSorted);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.asList(), Arrays.asList()),
                Arguments.of(Arrays.asList(1), Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(2, 1), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 2, 1), Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 2, 1, 2, 3), Arrays.asList(1, 2, 2, 3, 3))
        );
    }

}
