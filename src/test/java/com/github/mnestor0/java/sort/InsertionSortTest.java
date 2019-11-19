package com.github.mnestor0.java.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    @ParameterizedTest
    @MethodSource("com.github.mnestor0.java.sort.TestData#testData")
    void testSort(Integer[] arrayToBeSorted, Integer[] expectedArray) {
        new InsertionSort<Integer>().sort(arrayToBeSorted);
        assertArrayEquals(expectedArray, arrayToBeSorted);
    }
}
