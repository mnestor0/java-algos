package com.github.mnestor0.java.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class InsertionSortTest {

    @ParameterizedTest
    @MethodSource("com.github.mnestor0.java.sort.TestData#testData")
    void testSort(Integer[] arrayToBeSorted, Integer[] expectedArray) {
        new InsertionSort<Integer>().sort(arrayToBeSorted);
        assertArrayEquals(expectedArray, arrayToBeSorted);
    }
    @ParameterizedTest
    @MethodSource("com.github.mnestor0.java.sort.TestData#testData")
    void testSortLinked(Integer[] arrayToBeSorted, Integer[] expectedArray) {
        Object[] actual = new InsertionSort<Integer>().sortLinked(arrayToBeSorted);
        assertArrayEquals(expectedArray, actual);
    }
}
