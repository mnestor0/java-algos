package com.github.mnestor0.java.sort;

import java.util.LinkedList;

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

    public void sort(T[] toBeSorted) {
        T original;
        for (int i = 0; i < toBeSorted.length; i++) {
            for (int j = 0; j < i; j++) {
                if (toBeSorted[i].compareTo(toBeSorted[j]) < 0) {
                    original = toBeSorted[i];
                    System.arraycopy(toBeSorted, j, toBeSorted, j + 1, i - j);
                    toBeSorted[j] = original;
                }
            }
        }
    }

    public Object[] sortLinked(T[] array) {
        if (array.length == 0 || array.length == 1) return array;
        int newIndex = 0;
        LinkedList<T> linkedList = new LinkedList<>();
        for (T element : array) {
            for (; newIndex < linkedList.size(); newIndex++) {
                if (element.compareTo(linkedList.get(newIndex)) < 0) {
                    break;
                }
            }
            linkedList.add(newIndex, element);
        }
        return linkedList.toArray();
    }
}
