package com.github.mnestor0.java.sort;

import java.util.Comparator;

/*
    See base class for more info.
 */
public class MergeSortTopDown extends MergeSortAbstract {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        T[] workArray = array.clone();
        if (array.length == 0 || array.length == 1) return;
        int subFirst = 0;
        int subLast = array.length - 1;
        sort(array, workArray, subFirst, subLast, comparator);
    }

    private <T> void sort(T[] array, T[] workArray, int subFirst, int subLast, Comparator<T> comparator) {
        int subLength = subLast - subFirst + 1;
        if (subLength == 1) {
            return;
        }
        int subMiddle = (subLast - subFirst) / 2 + subFirst;
        sort(array, workArray, subFirst, subMiddle, comparator);
        sort(array, workArray, subMiddle + 1, subLast, comparator);
        System.arraycopy(array, subFirst, workArray, subFirst, subLength);
        merge(array, workArray, subFirst, subMiddle + 1, subLast, comparator);
    }
}
