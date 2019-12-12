package com.github.mnestor0.java.sort;

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
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    private static final int ROOT_INDEX = 0;

    @Override
    public void sort(T[] array) {
        int lastElement = array.length - 1;
        for (int i = array.length / 2; i >= ROOT_INDEX; i--) {
            sink(array, i, lastElement);
        }
        for (int i = 0; i < array.length; i++) {
            swap(array, ROOT_INDEX, lastElement);
            lastElement--;
            sink(array, ROOT_INDEX, lastElement);
        }
    }

    private void sink(T[] workArray, int index, int lastElement) {
        int leftChildIndex;
        int rightChildIndex;
        for (int i = index; i <= lastElement / 2;) {
            leftChildIndex = i * 2 + 1;
            rightChildIndex = i * 2 + 2;
            if (rightChildIndex <= lastElement
                    && workArray[rightChildIndex].compareTo(workArray[i]) > 0
                    && workArray[rightChildIndex].compareTo(workArray[leftChildIndex]) > 0) {
                swap(workArray, i, rightChildIndex);
                i = rightChildIndex;
            } else if (workArray[leftChildIndex].compareTo(workArray[i]) > 0) {
                swap(workArray, i, leftChildIndex);
                i = leftChildIndex;
            } else {
                break;
            }
        }
    }

    private void swap(T[] workArray, int index1, int index2) {
        T swap = workArray[index1];
        workArray[index1] = workArray[index2];
        workArray[index2] = swap;
    }
}
