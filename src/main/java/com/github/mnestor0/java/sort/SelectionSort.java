package com.github.mnestor0.java.sort;

/*
    This sorting methods works as follows:
    1. Find the smallest element, put it in the first index of the array.
    2. Find the second smallest element, put it in the second index of the array.
    3. Repeat until the last element.

    Time complexity is O(n^2).
    Memory complexity is O(1).

 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] toBeSorted) {
        for (int i = 0; i < toBeSorted.length - 1; i++) {
            int minOfSubArray = findMinIndex(toBeSorted, i);
            swap(toBeSorted, i, minOfSubArray);
        }
    }

    private int findMinIndex(T[] array, int from) {
        int min = from;
        for (int i = from; i < array.length; i++) {
            if (array[i].compareTo(array[min]) < 0) {
                min = i;
            }
        }
        return min;
    }

    private void swap(T[] array, int index1, int index2) {
        T swap = array[index1];
        array[index1] = array[index2];
        array[index2] = swap;
    }
}
