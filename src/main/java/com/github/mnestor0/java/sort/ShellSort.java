package com.github.mnestor0.java.sort;

import java.util.Arrays;

/*
    This is a variation of the insertion sort, which should optimize insertion sort characteristic:
    it works fast for mostly sorted sets and badly otherwise, because each iteration moves elements left by 1 position.
    The idea is to optimize this by dividing the set to be sorted to smaller groups, where each group contains every
    h-th element of the original set, sort the sets, then decrease the h (gap) and sort again.
    The original set will be finally sorted when sorting is done for h = 1.

    It's hard to determine the time complexity, because different values of h and different lengths of the sets affect
    the complexity greatly. The memory complexity is O(1), because it is in-place algorithm.
    Using gaps defined by Knuth: (3^k - 1) / 2, not greater than N (1, 4, 13, 40, 121, 364, ...)
    the time complexity is O(n^(3/2)).

    Note: Using Knuth's algorithm, subsequent k values can be counted by gap(k+1)/3 rounded down because
    Knuth's gaps are integers and:
    (3^(k + 1) - 1) / 2 / 3 - (3^k - 1) / 2 = (3^k/2 - 1/6) - (3^k/2 - 1/2) = -1/6 + 1/2 = 1/3
 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        Integer[] array = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8};
        new ShellSort<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(T[] array) {
        if (array.length == 0 || array.length == 1) return;
        int gap = findInitialGap(array);
        int i, j;
        T element;
        while (gap >= 1) {
            for (i = gap; i < array.length; i++) {
                element = array[i];
                for (j = i; j >= gap && array[j - gap].compareTo(element) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = element;
            }
            gap /= 3;
        }
    }

    private int findInitialGap(T[] array) {
        int k = 1;
        while (calculateGap(k + 1) < array.length) {
            k++;
        }
        return calculateGap(k);
    }

    private int calculateGap(int k) {
        return (int) (Math.pow(3, k) - 1) / 2;
    }
}