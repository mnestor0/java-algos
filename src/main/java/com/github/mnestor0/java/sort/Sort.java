package com.github.mnestor0.java.sort;

public interface Sort<T extends Comparable<T>> {
    void sort(T[] array);
}
