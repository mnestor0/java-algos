package com.github.mnestor0.java.sort;

/*
    Quicksort is an unstable algorithm, which is based on divide and conquer paradigm.
    The algorithm is:
    1. Partition an array in a way that there is an index j (pivot element), for which following statements are true:
        a. Element from array[0] to array[j-1] are smaller than array[j].
        b. Element from array[j+1] to array[array.length] are bigger than array[j] or equal.
    2. Recursively sort subarray to the left of the pivot element.
    3. Recursively sort subarray to the right of the pivot element.
    Time complexity on average O(n * log(n)). Worst-case complexity is for already sorted arrays - O(n^2).
    The pivot element can be chosen in many ways.
    Sedgewick suggests to pick median of the first, middle and the last element of the subarray.
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    private static final int FALLBACK_TO_INSERTION_SORT = 10;
    private InsertionSort<T> insertionSort = new InsertionSort<>();

    @Override
    public void sort(T[] array) {
//        new DurstenfeldShuffle<T>().shuffle(array);
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        if (hi - lo < FALLBACK_TO_INSERTION_SORT) {
            // Optimization -fallback to insertion sort for small size
            insertionSort.sort(array, lo, hi);
            return;
        }
        int k = partition(array, lo, hi);
        quicksort(array, lo, k - 1);
        quicksort(array, k + 1, hi);
    }

    private int partition(T[] array, int lo, int hi) {
        findPivot(array, lo, hi);
        int pivot = hi;
        int i = lo;
        int j = hi;
        while (i < j) {
            while (array[i].compareTo(array[pivot]) < 0 && i < j) {
                i++;
            }
            while (array[j].compareTo(array[pivot]) >= 0 && j > i) {
                j--;
            }
            if (array[i].compareTo(array[j]) > 0) {
                swap(array, i, j);
            }
        }
        swap(array, pivot, i);
        return i;
    }

    private void findPivot(T[] array, int lo, int hi) {
        // Optimization - put median of first, middle and the last element to the end of the array.
        int mid = lo + (hi - lo) / 2;
        if (array[lo].compareTo(array[mid]) >= 0 && array[mid].compareTo(array[hi]) >= 0) {
            swap(array, mid, hi);
        }
        if (array[mid].compareTo(array[lo]) >= 0 && array[lo].compareTo(array[hi]) >= 0) {
            swap(array, lo, hi);
        }
    }

    private void swap(T[] array, int i, int j) {
        T swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}
