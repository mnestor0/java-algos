package com.github.mnestor0.java.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    private List<Sort> sortList = Arrays.asList(
            new BubbleSort(),
            new InsertionSort(),
            new MergeSortTopDown(),
            new MergeSortTopDownOptimized(),
            new MergeSortBottomUp(),
            new SelectionSort(),
            new ShellSort(),
            new QuickSort(),
            new HeapSort());

    @ParameterizedTest
    @MethodSource("testData")
    void testSort(Integer[] arrayToBeSorted) {
        Integer[] expectedArray = arrayToBeSorted.clone();
        Arrays.sort(expectedArray);
        for (Sort sort : sortList) {
            sort.sort(arrayToBeSorted);
            assertArrayEquals(expectedArray, arrayToBeSorted, String.format("%s, %s",
                    Arrays.toString(expectedArray), Arrays.toString(arrayToBeSorted)));
        }
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of((Object) new Integer[0]),
                Arguments.of((Object) new Integer[] {1}),
                Arguments.of((Object) new Integer[] {1, 2}),
                Arguments.of((Object) new Integer[] {2, 1}),
                Arguments.of((Object) new Integer[] {1, 2, 3}),
                Arguments.of((Object) new Integer[] {3, 2, 1}),
                Arguments.of((Object) new Integer[] {3, 2, 1, 2, 3}),
                Arguments.of((Object) new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
        );
    }
}