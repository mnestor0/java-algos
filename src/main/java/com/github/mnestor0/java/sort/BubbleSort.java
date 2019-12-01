package com.github.mnestor0.java.sort;

/*
    Very simple sorting algorithm. It's rather slow and so impractical. Usually other sort algorithms are used.
    1. Take an element of the array.
    2. Check if it is bigger than the subsequent element.
    3. If yes, swap the elements.
    4. Move to another element.
    5. Repeat until array is sorted.
    Time complexity O(n^2).
    Memory is O(1).

    Two optimizations are easy:
    1. Notice that every n-th iteration puts n-th biggest element in place.
    2. Notice that each pass might put more than one element in place,
        that all elements after last swap in given are already sorted.
 */

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] array) {
        boolean swapped;
        T swap;
        int i;
        int lastSwapped = array.length - 1;
        do {
            swapped = false;
            for (i = 0; i < lastSwapped; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                    swapped = true;
                }
            }
            lastSwapped = i;
        } while (swapped);
    }
}
