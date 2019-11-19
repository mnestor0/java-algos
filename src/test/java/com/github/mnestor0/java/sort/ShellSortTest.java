package com.github.mnestor0.java.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @ParameterizedTest
    @MethodSource("com.github.mnestor0.java.sort.TestData#testData")
    void testSort(Integer[] arrayToBeSorted, Integer[] expectedArray) {
        new ShellSort<Integer>().sort(arrayToBeSorted);
        assertArrayEquals(expectedArray, arrayToBeSorted, String.format("%s, %s",
                Arrays.toString(expectedArray), Arrays.toString(arrayToBeSorted)));
    }
}