package com.github.mnestor0.java.exercises;

/*
  This problem was asked by Stripe.
  Given an array of integers, find the first missing positive integer in linear time and constant space.
  In other words, find the lowest positive integer that does not exist in the array.
  The array can contain duplicates and negative numbers as well.
  For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
  You can modify the input array in-place.

  Solution:
  Put each considered element - in this case each positive integer - sequentially into the table, starting from index 0.
  Since we are looking for a positive integer and a java array is 0-indexed then a correct index for number n is n-1:
  For example, index 0 for number 1, index 1 for number 2 etc.
  The numbers can be put into correct places in linear time in a following way:
  Iterate over indices of the array -
  For each index, check if the element at this index is the right element.
  If not, swap the element with the element at the target position. For example, if at index 0 there's a number 3,
  put the number 3 to an index 2 (n - 1) and the element from index 2 to index 0.
  Keep repeating this step unless:
    1. The element at the current index doesn't have a corresponding element in the array (is negative or too large),
    2. The element at the target index is a correct element. (If currently considered index is 1, the element is 3 and the element at index 2 is also 3,
        or if currently considered element is 3 and the index is 2).
  Since the fact that each swap puts an element into a correct place then most N swaps will be done, so that means linear time.
  Then iterate over the array again and if any element is at a wrong position then this position is the missing integer.
  If all array elements are in the correct places then the missing integer is the size of the array + 1.
 */
public class FindMissingNatural {

    public int find(int[] array) {
        int currentElement;
        for (int i = 0; i < array.length; i++) {
            currentElement = array[i];
            if (currentElement - 1 == i) {
                continue;
            }
            while(currentElement > 0 && currentElement <= array.length && array[currentElement - 1] != currentElement) {
                swap(array, i, currentElement - 1);
                currentElement = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

    private void swap(int[] array, int a, int b) {
        int swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }
}
