package com.github.mnestor0.java.sort;

import java.util.Comparator;

import static com.github.mnestor0.java.sort.SortUtils.swap;

/*
    Priority queue is a data structure, which provides two operations, removeMaximum() and insert().
    It can be implemented with a sorted array, unsorted array or a linked list. All these structure require
    O(n) time complexity for removing and inserting items.
    In this case a heap-ordered complete binary search tree is used, where
    - heap-ordered - parent element is greater or equal than children
    - complete - every level is full, possibly except last where all nodes are maximally moved to the left
    - binary search tree - a tree, where each node has at most 2 children
    With this implementation, the heap algorithms require no more than 1 + lg n compares for insert
    and no more than 2 lg n compares for remove the maximum.

 */
public class HeapSort implements Sort {

    private static final int ROOT_INDEX = 0;

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        if (array.length < 2) return;
        int lastElement = array.length - 1;
        for (int i = getParentIndex(lastElement); i >= ROOT_INDEX; i--) {
            sink(array, i, lastElement, comparator);
        }
        while (lastElement > 0) {
            swap(array, ROOT_INDEX, lastElement);
            lastElement--;
            sink(array, ROOT_INDEX, lastElement, comparator);
        }
    }

    private <T> void sink(T[] workArray, int index, int lastElement, Comparator<T> comparator) {
        if (lastElement < 1) {
            return;
        }
        int leftChildIndex;
        int rightChildIndex;
        int parentIndex = getParentIndex(lastElement);
        for (int i = index; i <= parentIndex;) {
            leftChildIndex = i * 2 + 1;
            rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex <= lastElement
                    && comparator.compare(workArray[rightChildIndex], workArray[i]) > 0
                    && comparator.compare(workArray[rightChildIndex], workArray[leftChildIndex]) > 0) {
                swap(workArray, i, rightChildIndex);
                i = rightChildIndex;
            } else if (comparator.compare(workArray[leftChildIndex], workArray[i]) > 0) {
                swap(workArray, i, leftChildIndex);
                i = leftChildIndex;
            } else {
                break;
            }
        }
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }
}
