package com.github.mnestor0.java.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerializeBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("serializeTestData")
    public void serializeTest(BinaryTreeNode treeBinaryTreeNode, String expectedResult) {
        SerializeBinaryTree serializer = new SerializeBinaryTree();
        assertEquals(expectedResult, serializer.serialize(treeBinaryTreeNode));
    }

    static Stream<Arguments> serializeTestData() {
        return Stream.of(
                Arguments.of(new BinaryTreeNode(""), "<;>"),
                Arguments.of(new BinaryTreeNode("", new BinaryTreeNode("")), "<<;>;>"),
                Arguments.of(nodeWithRightChild("", new BinaryTreeNode("")), "<;<;>>"),
                Arguments.of(new BinaryTreeNode("root"), "root<;>"),
                Arguments.of(new BinaryTreeNode("root", new BinaryTreeNode("left")), "root<left<;>;>"),
                Arguments.of(new BinaryTreeNode("root",
                        new BinaryTreeNode("left",
                        new BinaryTreeNode("left.left"))),
                        "root<left<left.left<;>;>;>"),
                Arguments.of(new BinaryTreeNode("root",
                        new BinaryTreeNode("left"),
                        new BinaryTreeNode("right")),
                        "root<left<;>;right<;>>")
        );
    }

    @ParameterizedTest
    @MethodSource("deserializeTestData")
    public void deserializeTest(String serializedTree, BinaryTreeNode expectedTree) {
        SerializeBinaryTree serializer = new SerializeBinaryTree();
        assertEquals(expectedTree, serializer.deserialize(serializedTree));
    }

    static Stream<Arguments> deserializeTestData() {
        return Stream.of(
                Arguments.of("<;>", new BinaryTreeNode("")),
                Arguments.of("<<;>;>", new BinaryTreeNode("", new BinaryTreeNode(""))),
                Arguments.of("<;<;>>", nodeWithRightChild("", new BinaryTreeNode(""))),
                Arguments.of("root<;>", new BinaryTreeNode("root")),
                Arguments.of("root<left<;>;>", new BinaryTreeNode("root", new BinaryTreeNode("left")),
                Arguments.of("root<left<left.left<;>;>;>", new BinaryTreeNode("root", new BinaryTreeNode("left", new BinaryTreeNode("left.left")))),
                Arguments.of("root<left<;>;right<;>>", new BinaryTreeNode("root", new BinaryTreeNode("left"), new BinaryTreeNode("right"))))
        );
    }

    static BinaryTreeNode nodeWithRightChild(String value, BinaryTreeNode right) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        node.right = right;
        return node;
    }
}