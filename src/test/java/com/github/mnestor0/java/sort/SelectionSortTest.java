package com.github.mnestor0.java.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("com.github.mnestor0.java.sort.TestData#testData")
    void testSort(Integer[] arrayToBeSorted, Integer[] expectedArray) {
        new SelectionSort<Integer>().sort(arrayToBeSorted);
        assertArrayEquals(expectedArray, arrayToBeSorted);
    }
}
