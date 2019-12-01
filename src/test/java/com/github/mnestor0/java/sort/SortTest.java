package com.github.mnestor0.java.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    private List<Sort<Integer>> sortList = Arrays.asList(
            new BubbleSort<>(),
            new InsertionSort<>(),
            new MergeSortTopDown<>(),
            new MergeSortTopDownOptimized<>(),
            new MergeSortBottomUp<>(),
            new SelectionSort<>(),
            new ShellSort<>());

    @ParameterizedTest
    @MethodSource("com.github.mnestor0.java.sort.TestData#testData")
    void testSort(Integer[] arrayToBeSorted, Integer[] expectedArray) {
        for (Sort<Integer> sort : sortList) {
            sort.sort(arrayToBeSorted);
            assertArrayEquals(expectedArray, arrayToBeSorted, String.format("%s, %s",
                    Arrays.toString(expectedArray), Arrays.toString(arrayToBeSorted)));
        }
    }
}