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
    A HashSet can be used for this. Add all elements to a HashSet.
    Iterate over HashSet and check if desiredSum - currentValue exists in the Set.
 */
public class DoTwoNumberAddUpToK {

    public boolean addUp(Integer[] array, int desiredSum) {
        if (array.length < 2) return false;
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(array));
        return hashSet.stream().anyMatch(element -> hashSet.contains(desiredSum - element));
    }
}
