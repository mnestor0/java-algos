package com.github.mnestor0.java.sort;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class SortingPerformance {

    public static void main(String[] args) {
        List<Sort<Integer>> algorithms = SortingAlgorithms.get();
        algorithms.parallelStream().forEach(SortingPerformance::testPerformance);
    }

    private static void testPerformance(Sort<Integer> algorithm) {
        long averageTime = 0;
        for (int i = 0; i < 100; i++) {
            Integer[] array = createArray();
            long start = new Date().getTime();
            algorithm.sort(array);
            averageTime += new Date().getTime() - start;
        }
        System.out.println(algorithm.getClass().toString() + "=" + averageTime);
    }

    private static Integer[] createArray() {
        Integer[] array = new Integer[100000];
        Random random = new Random();
        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt();
        }
        return array;
    }
}
