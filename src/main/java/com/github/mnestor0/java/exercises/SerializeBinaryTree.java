package com.github.mnestor0.java.exercises;

/*
    This problem was asked by Google.
    Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
    and deserialize(s), which deserializes the string back into the tree.

    For example, given the following Node class
    class Node:
        def __init__(self, val, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right

    The following test should pass:
    node = Node('root', Node('left', Node('left.left')), Node('right'))
    assert deserialize(serialize(node)).left.left.val == 'left.left'

    Solution:
    Recurrently write nodes to String with a following formula: Node.value<Node.left;Node.right>
 */
public class SerializeBinaryTree {

    public String serialize(BinaryTreeNode rootNode) {
        StringBuilder builder = new StringBuilder();
        serialize(rootNode, builder);
        return builder.toString();
    }

    private StringBuilder serialize(BinaryTreeNode node, StringBuilder builder) {
        builder.append(node.value).append("<");
        if (node.left != null) {
            serialize(node.left, builder);
        }
        builder.append(";");
        if (node.right != null) {
            serialize(node.right, builder);
        }
        builder.append(">");
        return builder;
    }

    public BinaryTreeNode deserialize(String serializedTree) {
        return deserialize(serializedTree, 0).node;
    }

    private DeserializedNode deserialize(String serializedTree, int index) {
        if (index >= serializedTree.length()) {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode node = new BinaryTreeNode();
        int openingBracket = serializedTree.indexOf('<', index);
        if (openingBracket < 0) {
            throw new IllegalArgumentException();
        }
        node.value = serializedTree.substring(index, openingBracket);
        int workingIndex = openingBracket + 1;
        if (serializedTree.charAt(workingIndex) == '>') {
            return new DeserializedNode(node, workingIndex);
        }
        if (serializedTree.charAt(workingIndex) != ';') {
            DeserializedNode leftChild = deserialize(serializedTree, workingIndex);
            node.left = leftChild.node;
            workingIndex = leftChild.closingBracketIndex + 1;
        }
        if (serializedTree.charAt(workingIndex) != ';') {
            throw new IllegalArgumentException();
        }
        workingIndex += 1;
        if (serializedTree.charAt(workingIndex) != '>') {
            DeserializedNode rightChild = deserialize(serializedTree, workingIndex);
            node.right = rightChild.node;
            workingIndex = rightChild.closingBracketIndex + 1;
        }
        if (serializedTree.charAt(workingIndex) != '>') {
            throw new IllegalArgumentException();
        }
        return new DeserializedNode(node, workingIndex);
    }

    private static class DeserializedNode {
        BinaryTreeNode node;
        int closingBracketIndex;

        public DeserializedNode(BinaryTreeNode node, int closingBracketIndex) {
            this.node = node;
            this.closingBracketIndex = closingBracketIndex;
        }
    }
}
