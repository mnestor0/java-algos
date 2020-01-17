package com.github.mnestor0.java.exercises;

import java.util.Arrays;

/*
    This problem was asked by Amazon.
    There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
    Given N, write a function that returns the number of unique ways you can climb the staircase.
    The order of the steps matters.
    For example, if N is 4, then there are 5 unique ways:
        1, 1, 1, 1
        2, 1, 1
        1, 2, 1
        1, 1, 2
        2, 2
    What if, instead of being able to climb 1 or 2 steps at a time,
    you could climb any number from a set of positive integers X?
    For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

    Solution:
    For 4 steps:
      If the first step is 1, then there are 3 steps left.
      If the first step is 2, then there are 2 steps left.
      The result is: Number of combinations when 1 step was chosen + number of combinations when 2 steps where chosen.
    Next, for 3 steps:
      If the first step is 1, then there are 2 steps left.
      If the first step is 2, then there is only 1 step left.
      The result for 3 steps is equal to number of combinations for 2 steps plus combinations for a 1 step.
    Number of combinations for 2 steps is 2. (2 times 1 step, or one time 2 steps).
    Number of combinations for 1 step is 1.
    This can be done recurrently, similarly to Fibonacci sequence.
    Time complexity is O(n), memory complexity is O(1).

    If, instead of being able to climb 1 or 2 steps an array of possible steps is given,
    then the solution is to keep history of previous steps (equal to the highest possible move),
    then for each index check which of the moves is possible
    If x move is possible, then add to number of combinations the number of combinations for n - x steps.
    If the number of combinations for n-x steps in history is equal to 0 then add 1
    ( this would be the first time that a certain move is encountered ).

 */
public class Stairs {

    public static void main(String[] args) {
        Stairs s = new Stairs();
        System.out.println(s.count(1));
        System.out.println(s.count(2));
        System.out.println(s.count(3));
        System.out.println(s.count(4));
        System.out.println(s.count(5));
        System.out.println("=============");
        System.out.println(s.count(1, array(1, 2)));
        System.out.println(s.count(2, array(1, 2)));
        System.out.println(s.count(3, array(1, 2)));
        System.out.println(s.count(4, array(1, 2)));
        System.out.println(s.count(5, array(1, 2)));
        System.out.println("=============");
        System.out.println(s.count(1, array(1, 3, 5)));
        System.out.println(s.count(2, array(1, 3, 5)));
        System.out.println(s.count(3, array(1, 3, 5)));
        System.out.println(s.count(4, array(1, 3, 5)));
        System.out.println(s.count(5, array(1, 3, 5)));
        System.out.println(s.count(6, array(1, 3, 5)));
    }

    private static int[] array(int... args) {
        return args;
    }

    public int count(int steps) {
        if (steps == 1) return 1;
        if (steps == 2) return 2;
        int secondLast = 1;
        int last = 2;
        int current = 2;
        for (int i = 2; i < steps; i++) {
            current = secondLast + last;
            secondLast = last;
            last = current;
        }
        return current;
    }

    public int count(int maxSteps, int[] moves) {
        if (moves.length == 0) return 0;
        Arrays.sort(moves);
        int maxMove = moves[moves.length - 1];
        int[] previousSteps = new int[maxMove + 1];
        int currentMove = 0;
        int lastStep = previousSteps.length - 1;
        for (int numberOfSteps = 1; numberOfSteps <= maxSteps; numberOfSteps++) {
            currentMove = 0;
            for (int move : moves) {
                if (move <= numberOfSteps) {
                    int nthPreviousStep = previousSteps[previousSteps.length - move];
                    if (nthPreviousStep == 0) {
                        currentMove += 1;
                    } else {
                        currentMove += nthPreviousStep;
                    }
                }
            }
            // Update history
            System.arraycopy(previousSteps, 1, previousSteps, 0, lastStep);
            previousSteps[lastStep] = currentMove;
        }
        return currentMove;
    }
}
