package com.github.mnestor0.java.sort;

import java.util.Arrays;

/*
    This sorting methods works as follows:
    1. Take every element of the array (n).
    2. Iterate over array from index 0 and find an index i,
        for which the following is true: n < array[i].
    3. Insert the element to index i.
    Time complexity is O(n^2).
    Memory complexity is O(1).

 */
public class InsertionSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] array = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8};
        new InsertionSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(T[] array) {
        if (array.length == 0 || array.length == 1) return;
        T original;
        int i, j;
        for (i = 1; i < array.length; i++) {
            original = array[i];
            for (j = i; j > 0 && array[j - 1].compareTo(original) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = original;
        }
    }
}
