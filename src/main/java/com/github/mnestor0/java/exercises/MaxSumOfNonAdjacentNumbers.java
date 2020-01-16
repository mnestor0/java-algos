package com.github.mnestor0.java.exercises;

/*
  This problem was asked by Airbnb.
  Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
  For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
  Follow-up: Can you do this in O(N) time and constant space?

  Solution:
  f([2, 4, 6, 2, 5]) = Max(5 + f([2, 4, 6]), f([2, 4, 6, 2]))
  f([2, 4, 6, 2])    = Max(2 + f([2, 4])   , f([2, 4, 6]))
  f([2, 4, 6])       = Max(6 + f([2])      , f([2, 4]))
  f([2, 4])          = Max(2, 4)
  f([2])             = 2
 */
public class MaxSumOfNonAdjacentNumbers {

    public int find(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int secondlast = array[0];
        if (array.length == 1) {
            return secondlast;
        }
        int last = Math.max(array[0], array[1]);
        if (array.length == 2) {
            return last;
        }
        int sum = 0;
        for (int i = 2; i < array.length; i++) {
            sum = Math.max(secondlast + array[i], last);
            secondlast = last;
            last = sum;
        }
        return sum;
    }
}
