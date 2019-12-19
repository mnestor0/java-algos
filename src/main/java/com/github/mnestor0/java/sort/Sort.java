package com.github.mnestor0.java.sort;

import java.util.Comparator;

public interface Sort {

    default <E extends Comparable<E>> void sort(E[] array) {
        sort(array, Comparable::compareTo);
    }

    <T> void sort(T[] array, Comparator<T> comparator);
}
