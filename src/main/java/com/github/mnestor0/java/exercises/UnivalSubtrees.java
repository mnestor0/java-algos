package com.github.mnestor0.java.exercises;

/*
  This problem was asked by Google.
  A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
  Given the root to a binary tree, count the number of unival subtrees.
  For example, the following tree has 5 unival subtrees:
     0
    / \
   1   0
      / \
     1   0
    / \
   1   1

   Solution:
   Recursive traversal, time complexity O(n), memory O(n).
   Not stacksafe.
 */
public class UnivalSubtrees {

    public int count(BinaryTreeNode rootNode) {
        Accumulator accumulator = new Accumulator();
        isUnivalTree(rootNode, accumulator);
        return accumulator.value;
    }

    public boolean isUnivalTree(BinaryTreeNode node, Accumulator accumulator) {
        boolean leftIsUnival = node.left == null
                || isUnivalTree(node.left, accumulator)
                && node.value.equals(node.left.value);
        boolean rightIsUnival = node.right == null
                || isUnivalTree(node.right, accumulator)
                && node.value.equals(node.right.value);
        if (leftIsUnival && rightIsUnival) {
            accumulator.value++;
            return true;
        }
        return false;
    }

    private static final class Accumulator {
        int value;
    }
}
