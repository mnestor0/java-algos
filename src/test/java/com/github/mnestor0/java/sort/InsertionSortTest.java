package com.github.mnestor0.java.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class InsertionSortTest {

    @ParameterizedTest
    @MethodSource("testData")
    void testSort(List<Integer> toBeSorted, List<Integer> expectedList) {
        Integer[] arrayToBeSorted = toBeSorted.toArray(new Integer[0]);
        Integer[] expectedArray = expectedList.toArray(new Integer[0]);
        new InsertionSort<Integer>().sort(arrayToBeSorted);
        assertArrayEquals(expectedArray, arrayToBeSorted);
    }
    @ParameterizedTest
    @MethodSource("testData")
    void testSortLinked(List<Integer> toBeSorted, List<Integer> expectedList) {
        Integer[] expectedArray = expectedList.toArray(new Integer[0]);
        Object[] actual = new InsertionSort<Integer>().sortLinked(toBeSorted.toArray(new Integer[0]));
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expectedArray, actual);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.asList(), Arrays.asList()),
                Arguments.of(Arrays.asList(1), Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1)),
                Arguments.of(Arrays.asList(2, 1), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 2, 1), Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 2, 1, 2, 3), Arrays.asList(1, 2, 2, 3, 3))
        );
    }

}
