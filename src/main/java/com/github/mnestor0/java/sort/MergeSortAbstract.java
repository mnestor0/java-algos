package com.github.mnestor0.java.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
    Merge sort is an algorithm that is an example of divide and conquer paradigm.
    Most times it is a stable sort (positions of equal elements are the same after sorting).
    It is an asymptotically optimal algorithm, meaning worst case and best case time complexity is O(n*log(n)).
    There are two basic implementation of mergesort:
    1. Top-down - recursive implementation, which splits the array into smaller subarrays until the length is 1 and
        merges them back.
    2. Bottom-up - iterative implementation, which treats given array as an array of 1-element long lists and merges
        them back to a sorted array.

    There are few optimizations possible. Quote from Algorithms by Sedgewick:
    * Use insertion sort for small subarrays. We can improve most recursive algorithms by handling small cases differently.
        Switching to insertion sort for small subarrays will improve the running time of a typical mergesort implementation by 10 to 15 percent.
    * Test whether array is already in order. We can reduce the running time to be linear for arrays that are already in order
        by adding a test to skip call to merge() if a[mid] is less than or equal to a[mid+1].
        With this change, we still do all the recursive calls, but the running time for any sorted subarray is linear.
    * Eliminate the copy to the auxiliary array. It is possible to eliminate the time (but not the space) taken
        to copy to the auxiliary array used for merging. To do so, we use two invocations of the sort method,
        one that takes its input from the given array and puts the sorted output in the auxiliary array;
        the other takes its input from the auxiliary array and puts the sorted output in the given array.
        With this approach, in a bit of mindbending recursive trickery, we can arrange the recursive calls
        such that the computation switches the roles of the input array and the auxiliary array at each level.
 */
public abstract class MergeSortAbstract implements Sort {

    protected <T> void merge(T[] array, T[] workArray, int aFirst, int bFirst, int bLast, Comparator<T> comparator) {
        // Next condition statement is optimization
        boolean setAlreadySorted = bFirst < array.length && comparator.compare(array[bFirst - 1], array[bFirst]) <= 0;
        if (setAlreadySorted) {
            return;
        }
        int ai = aFirst, bi = bFirst;
        int length = bLast - aFirst + 1;
        for(int i = aFirst; i < (aFirst + length); i++) {
            if (bi > bLast || (ai < bFirst && comparator.compare(workArray[ai], workArray[bi]) <= 0)) {
                array[i] = workArray[ai];
                ai += 1;
            } else {
                array[i] = workArray[bi];
                bi += 1;
            }
        }
    }
}
