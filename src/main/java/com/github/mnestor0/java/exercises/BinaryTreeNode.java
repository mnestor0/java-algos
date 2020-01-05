package com.github.mnestor0.java.exercises;

import java.util.Objects;

public class BinaryTreeNode {
    String value;
    BinaryTreeNode left, right;
    public BinaryTreeNode() {}
    public BinaryTreeNode(String value) {
        this.value = value;
    }
    public BinaryTreeNode(String value, BinaryTreeNode left) {
        this.value = value;
        this.left = left;
    }
    public BinaryTreeNode(String value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean equals(Object other) {
        if (other.getClass() != this.getClass()) {
            return false;
        }
        BinaryTreeNode o = (BinaryTreeNode) other;
        return Objects.equals(this.value, o.value)
                && Objects.equals(this.left, o.left)
                && Objects.equals(this.right, o.right);
    }
}
