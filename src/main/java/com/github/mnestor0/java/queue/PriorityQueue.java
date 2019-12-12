package com.github.mnestor0.java.queue;

public interface PriorityQueue<T extends Comparable<T>> {

    T removeMaximum();
    void insert(T[] elements);
    void insert(T element);
    T[] toArray();
}
