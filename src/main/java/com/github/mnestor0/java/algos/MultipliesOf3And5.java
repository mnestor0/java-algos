package com.github.mnestor0.java.algos;

/*
    Problem:
    https://projecteuler.net/problem=1
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.


    Solution:
    The trivial solution is to iterate over all numbers up to a 1000 and sum those which are divisible by 3 or 5.

    The problem is the time complexity O(n). Let's find a better way. Let's call our function multiplies(n).
    multiplies(20) = 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78
    3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = (3 + 6 + 9 + 12 + 15 + 18) + (5 + 10)
    Looks like we could try to approach this by counting a sum of all multiplies of 3 and sum of all multiplies of 5.
    The problem is then that some numbers might appear twice, like 15. The answer is simple: we need to find a sum
    of multiplies of 3, a sum of multiplies of 5, add them and subtract a sum of multiplies of 15, so:
    multiplies(20) = (3 + 6 + 9 + 12 + 15 + 18) + (5 + 10 + 15) - (15) = 78
    multiplies(n) = sumDivisibleBelow(3, n) + sumDivisibleBelow(5, n) - sumDivisibleBelow(15, n)

    Now, how to find a sum of divisible numbers? It's easy if we notice the following:
    sumDivisibleBelow(3, 20) = 3 + 6 + 9 + 12 + 15 + 18 = 3 * (1 + 2 + 3 + 4 + 5 + 6)
    sumDivisibleBelow(5, 20) = 5 + 10 + 15 = 5 * (1 + 2 + 3)
    Let's notice that the highest number in parentheses is also the count of divisible numbers under the boundary.
    This number can be found as follows maxNumberUnderBoundary / divisible
    (20 - 1) / 3 = 6
    (20 - 1) / 5 = 3
    Notice that we subtract 1 from 20, because 19 is the highest number under the limit 20.
    We also know how to find a sum of natural numbers 1 + 2 + ... + n = n * (n + 1) / 2.
    Gathering all info, the function sumDivisibleBelow can be defined as follows:
    sumDivisibleBelow(i, n):
        countOfNaturals = (n - 1) / i
        sumOfNaturals = countOfNaturals * (countOfNaturals + 1) / 2
        return i * sumOfNaturals
    Using this algorithm we reduced time complexity to O(1).
 */
public class MultipliesOf3And5 {

    public static int multiplies(int n) {
        return sumDivisibleBelow(3, n) + sumDivisibleBelow(5, n) - sumDivisibleBelow(15, n);
    }

    private static int sumDivisibleBelow(int i, int n) {
        int maxValue = n - 1;
        int countOfNaturals = maxValue / i;
        int sumOfNaturals = countOfNaturals * (countOfNaturals + 1) / 2;
        return i * sumOfNaturals;
    }
}
