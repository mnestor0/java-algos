package com.github.mnestor0.java.sort;

import java.util.Comparator;

import static com.github.mnestor0.java.sort.SortUtils.swap;

/*
    This sorting methods works as follows:
    1. Find the smallest element, put it in the first index of the array.
    2. Find the second smallest element, put it in the second index of the array.
    3. Repeat until the last element.

    Time complexity is O(n^2).
    Memory complexity is O(1).

 */
public class SelectionSort implements Sort {

    public <T> void sort(T[] toBeSorted, Comparator<T> comparator) {
        for (int i = 0; i < toBeSorted.length - 1; i++) {
            int minOfSubArray = findMinIndex(toBeSorted, i, comparator);
            swap(toBeSorted, i, minOfSubArray);
        }
    }

    private <T> int findMinIndex(T[] array, int from, Comparator<T> comparator) {
        int min = from;
        for (int i = from; i < array.length; i++) {
            if (comparator.compare(array[i], array[min]) < 0) {
                min = i;
            }
        }
        return min;
    }
}
