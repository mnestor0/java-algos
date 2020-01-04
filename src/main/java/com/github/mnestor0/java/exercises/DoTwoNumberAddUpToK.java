package com.github.mnestor0.java.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    This problem was recently asked by Google.
    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    Bonus: Can you do this in one pass?

    Solution:
    A HashSet can be used for this:
      1. Iterate over array
      2. Check if complementary number exists in a hashset. If it does return true.
      3. If not, add current number to the hashset
 */
public class DoTwoNumberAddUpToK {

    public boolean addUp(Integer[] array, int desiredSum) {
        Set<Integer> numbersSeen = new HashSet<>();
        for (Integer integer : array) {
            if (numbersSeen.contains(desiredSum - integer)) {
                return true;
            }
            numbersSeen.add(integer);
        }
        return false;
    }
}
