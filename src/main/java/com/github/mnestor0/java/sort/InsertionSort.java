package com.github.mnestor0.java.sort;

import java.util.Comparator;

/*
    This sorting methods works as follows:
    1. Take every element of the array (n).
    2. Iterate over array from index 0 and find an index i,
        for which the following is true: n < array[i].
    3. Insert the element to index i.
    Time complexity is O(n^2).
    Memory complexity is O(1).

 */
public class InsertionSort implements Sort {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        if (array.length == 0 || array.length == 1) return;
        T original;
        int i, j;
        for (i = 1; i < array.length; i++) {
            original = array[i];
            for (j = i; j > 0 && comparator.compare(array[j - 1], original) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = original;
        }
    }

    public <T> void sort(T[] array, int start, int end, Comparator<T> comparator) {
        if (array.length == 0 || array.length == 1) return;
        T original;
        int i, j;
        for (i = start + 1; i <= end; i++) {
            original = array[i];
            for (j = i; j > start && comparator.compare(array[j - 1], original) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = original;
        }
    }
}
