package com.github.mnestor0.java.sort;

import java.util.Comparator;

import static com.github.mnestor0.java.util.ArrayUtils.swap;

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
public class QuickSort implements Sort {

    private static final int FALLBACK_TO_INSERTION_SORT = 10;
    private InsertionSort insertionSort = new InsertionSort();

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
//        new DurstenfeldShuffle<T>().shuffle(array);
        quicksort(array, 0, array.length - 1, comparator);
    }

    private <T> void quicksort(T[] array, int lo, int hi, Comparator<T> comparator) {
        if (lo >= hi) {
            return;
        }
        if (hi - lo < FALLBACK_TO_INSERTION_SORT) {
            // Optimization -fallback to insertion sort for small size
            insertionSort.sort(array, lo, hi, comparator);
            return;
        }
        int k = partition(array, lo, hi, comparator);
        quicksort(array, lo, k - 1, comparator);
        quicksort(array, k + 1, hi, comparator);
    }

    private <T> int partition(T[] array, int lo, int hi, Comparator<T> comparator) {
        findPivot(array, lo, hi, comparator);
        int pivot = hi;
        int i = lo;
        int j = hi;
        while (i < j) {
            while (comparator.compare(array[i], array[pivot]) < 0 && i < j) {
                i++;
            }
            while (comparator.compare(array[j], array[pivot]) >= 0 && j > i) {
                j--;
            }
            if (comparator.compare(array[i], array[j]) > 0) {
                swap(array, i, j);
            }
        }
        swap(array, pivot, i);
        return i;
    }

    private <T> void findPivot(T[] array, int lo, int hi, Comparator<T> comparator) {
        // Optimization - put median of first, middle and the last element to the end of the array.
        int mid = lo + (hi - lo) / 2;
        if (comparator.compare(array[lo], array[mid]) >= 0 && comparator.compare(array[mid], array[hi]) >= 0) {
            swap(array, mid, hi);
        }
        if (comparator.compare(array[mid], array[lo]) >= 0 && comparator.compare(array[lo], array[hi]) >= 0) {
            swap(array, lo, hi);
        }
    }
}
