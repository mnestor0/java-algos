package com.github.mnestor0.java.exercises;

/*
  This problem was asked by Uber.
  Given an array of integers, return a new array such that each element at index i of the new array
  is the product of all the numbers in the original array except the one at i.
  For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
  If our input was [3, 2, 1], the expected output would be [2, 3, 6].
  Don't use division and achieve time complexity O(n).

  Solution:
  Create an array of left-side products left[], where left[i] contains products of all numbers to the left of i.
  Create an array of right-side products right[], where right[i] contains products of all numbers to the right of i.
  For each i multiply the matching element of the left array and right array.
 */
public class ProductArray {

    public int[] findProduct(int[] array) {
        if (array.length < 2) {
            return new int[0];
        }
        int[] tempArray = new int[array.length];
        tempArray[0] = 1;
        int rightProduct = 1;
        for (int i = 1; i < array.length; i++) {
            tempArray[i] = tempArray[i - 1] * array[i - 1];
        }
        for (int i = array.length - 2; i >= 0; i--) {
            rightProduct *= array[i + 1];
            tempArray[i] *= rightProduct;
        }
        return tempArray;
    }
}
