package com.github.mnestor0.java.sort;

import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {

    public static List<Sort> get() {
        return Arrays.asList(
//                new BubbleSort(),
//                new InsertionSort(),
//                new SelectionSort(),
//                new ShellSort(),
//                new MergeSortTopDown(),
//                new MergeSortBottomUp(),
                new MergeSortTopDownOptimized(),
                new QuickSort(),
                new HeapSort());
    }
}
