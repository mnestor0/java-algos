package com.github.mnestor0.java.util;

public class ArrayUtils {

    public static <T> void swap(T[] array, int index1, int index2) {
        T swap = array[index1];
        array[index1] = array[index2];
        array[index2] = swap;
    }
}
