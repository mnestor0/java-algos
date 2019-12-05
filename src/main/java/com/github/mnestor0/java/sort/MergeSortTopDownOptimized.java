package com.github.mnestor0.java.sort;

/*
    Instead of copying contents from workArray to array, use them interchangeably.
    See base class for more info.
 */
public class MergeSortTopDownOptimized<T extends Comparable<T>> extends MergeSortAbstract<T> {

    private InsertionSort<T> insertionSort = new InsertionSort<>();

    public void sort(T[] array) {
        T[] workArray = array.clone();
        if (array.length == 0 || array.length == 1) return;
        int subFirst = 0;
        int subLast = array.length - 1;
        sort(array, workArray, subFirst, subLast, false);
    }

    private void sort(T[] array, T[] workArray, int subFirst, int subLast, boolean flip) {
        int subLength = subLast - subFirst + 1;
        if (subLength == 1) {
            return;
        }
        int subMiddle = (subLast - subFirst) / 2 + subFirst;
        if (flip) {
            // Optimization - use original array as work array and vice versa, back and forth and avoid copying elements.
            T[] swap = array;
            array = workArray;
            workArray = swap;
        }
        flip = !flip;
        if (subLength < 10) {
            // Optimization - fallback to insertion sort for small subarray
            insertionSort.sort(array, subFirst, subLast);
            return;
        }
        sort(array, workArray, subFirst, subMiddle, flip);
        sort(array, workArray, subMiddle + 1, subLast, flip);
        merge(array, workArray, subFirst, subMiddle + 1, subLast);
    }
}
