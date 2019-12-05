package com.github.mnestor0.java.shuffle;

import java.util.Arrays;
import java.util.Random;

public class DurstenfeldShuffle<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] check = new Integer[]{1, 2, 3, 4, 5};
        new DurstenfeldShuffle<Integer>().shuffle(check);
        System.out.println(Arrays.toString(check));
    }

    public void shuffle(T[] t) {
        Random random = new Random();
        int j;
        T swap;
        for (int i = t.length - 1; i > 0; i--) {
            j = random.nextInt(i);
            swap = t[i];
            t[i] = t[j];
            t[j] = swap;
        }
    }
}
