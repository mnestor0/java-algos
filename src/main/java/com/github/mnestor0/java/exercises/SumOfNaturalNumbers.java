package com.github.mnestor0.java.exercises;

/*
    Problem:
    Find sum of natural number from 1 to n (1 + 2 + 3 + ... + n)

    Example:
    n = 3  =>  1 + 2 + 3 = 6
    n = 4  =>  1 + 2 + 3 + 4 = 10

    Solution:
    Firstly, let's notice that sum of every element and a symmetrical element is always equal to n + 1.
    For example sum of the first element and the last element is equal to the sum of the second element and the second last element.
    For example, in a following equation:
    1 + 2 + 3 + 4,
    1 + 4 = 5 and
    2 + 3 = 5.
    When the number of elements is odd then a symmetrical element of the middle element is itself, so for
    1 + 2 + 3
    1 + 3 = 4 and
    2 + 2 = 4.
    In other words, for every i: element(i) + element(n + 1 - i) is always equal to n + 1.

    Using that knowledge we can substitute every element with half of that sum: (n + 1) / 2.
    For example, instead of writing this:
    1 + 2 + 3 = 6
    we can write this:
    2 + 2 + 2 = 6
    Or another example:
    1 + 2 + 3 + 4 + 5 + 6 = 21
    3.5 + 3.5 + 3.5 + 3.5 + 3.5 + 3.5 = 21

    The statement above can be made generic:
    3.5 * (1 + 1 + 1 + 1 + 1 + 1) = 21 or
    3.5 * 6 = 21
    Let's introduce a variable and there's a solution:
    sum(n) = n * ((n + 1) / 2)
 */
public class SumOfNaturalNumbers {

    static int sum(int n) {
        return (int) (n * ((n + 1) / 2.));
    }
}
