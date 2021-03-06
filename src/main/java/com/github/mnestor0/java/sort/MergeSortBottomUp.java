package com.github.mnestor0.java.sort;

import java.util.Comparator;

/*
    See base class for more info.
 */
public class MergeSortBottomUp extends MergeSortAbstract {

    public <T> void sort(T[] array, Comparator<T> comparator) {
        T[] workArray = array.clone();
        if (array.length == 0 || array.length == 1) return;
        for (int subLength = 1; subLength < array.length; subLength = subLength * 2) {
            for (int i = 0; i < array.length; i += subLength * 2) {
                int newSetLength = getNextSetLength(array, subLength, i);
                System.arraycopy(array, i, workArray, i, newSetLength);
                merge(array, workArray, i, i + subLength, i + newSetLength - 1, comparator);
            }
        }
    }

    private <T> int getNextSetLength(T[] array, int subLength, int i) {
        int newSetLength = subLength * 2;
        boolean isLastSetSmallerThanExpected = i + newSetLength >= array.length;
        if (isLastSetSmallerThanExpected) {
            newSetLength = array.length - i;
        }
        return newSetLength;
    }
}
