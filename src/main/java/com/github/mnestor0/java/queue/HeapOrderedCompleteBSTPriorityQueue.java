package com.github.mnestor0.java.queue;

import java.lang.reflect.Array;
import java.util.Arrays;

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
public class HeapOrderedCompleteBSTPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private static final int ROOT_INDEX = 0;
    private static final int DEFAULT_SIZE = 10;

    private T[] workArray;
    private int lastElement = -1;

    public HeapOrderedCompleteBSTPriorityQueue(Class<T> type) {
        this.workArray = (T[]) Array.newInstance(type, DEFAULT_SIZE);
    }

    @Override
    public void insert(T[] elements) {
        Arrays.stream(elements).forEach(this::insert);
    }

    @Override
    public void insert(T element) {
        lastElement++;
        if (lastElement >= workArray.length) {
            grow();
        }
        workArray[lastElement] = element;
        swim(lastElement);
    }

    @Override
    public T removeMaximum() {
        if (lastElement == -1) {
            throw new IllegalStateException("Heap is empty");
        }
        T max = workArray[ROOT_INDEX];
        swap(ROOT_INDEX, lastElement);
        workArray[lastElement] = null;
        lastElement--;
        sink(ROOT_INDEX);
        return max;
    }

    private void grow() {
        this.workArray = Arrays.copyOf(workArray, workArray.length * 2);
    }

    private void swim(int swimElement) {
        for (int i = swimElement; i > ROOT_INDEX; i = getParentIndex(i)) {
            int parentIndex = getParentIndex(i);
            if (workArray[parentIndex].compareTo(workArray[i]) >= 0) {
                break;
            }
            swap(parentIndex, i);
        }
    }

    private void swap(int index1, int index2) {
        T swap = workArray[index1];
        workArray[index1] = workArray[index2];
        workArray[index2] = swap;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void sink(int index) {
        int leftChildIndex;
        int rightChildIndex;
        for (int i = index; getLeftChildIndex(i) <= lastElement;) {
            leftChildIndex = getLeftChildIndex(i);
            rightChildIndex = getRightChildIndex(i);
            if (rightChildIndex <= lastElement
                    && workArray[rightChildIndex].compareTo(workArray[i]) > 0
                    && workArray[rightChildIndex].compareTo(workArray[leftChildIndex]) > 0) {
                swap(i, rightChildIndex);
                i = rightChildIndex;
            } else if (workArray[leftChildIndex].compareTo(workArray[i]) > 0) {
                swap(i, leftChildIndex);
                i = leftChildIndex;
            } else {
                break;
            }
        }
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getParentIndex(lastElement); i++) {
            builder.append("Item: " + workArray[i]
                    + " Left: " + workArray[getLeftChildIndex(i)] + " Right: " + workArray[getRightChildIndex(i)]);
            builder.append("\n");

        }
        return builder.toString();
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(workArray, lastElement + 1);
    }
}
