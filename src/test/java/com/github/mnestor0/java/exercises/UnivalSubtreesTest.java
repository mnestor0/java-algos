package com.github.mnestor0.java.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnivalSubtreesTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void testUnivalSubtrees(BinaryTreeNode node, long expectedResult) {
        UnivalSubtrees univalSubtrees = new UnivalSubtrees();
        assertEquals(expectedResult, univalSubtrees.count(node));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new BinaryTreeNode("0"), 1),
                Arguments.of(new BinaryTreeNode("1"), 1),
                Arguments.of(new BinaryTreeNode("0", new BinaryTreeNode("0")), 2),
                Arguments.of(new BinaryTreeNode("0", new BinaryTreeNode("1")), 1),
                Arguments.of(
                        new BinaryTreeNode("0",
                            new BinaryTreeNode("1"),
                            new BinaryTreeNode("1")), 2),
                Arguments.of(
                        new BinaryTreeNode("1",
                            new BinaryTreeNode("1"),
                            new BinaryTreeNode("1")), 3),
                Arguments.of(
                        new BinaryTreeNode("0",
                            new BinaryTreeNode("1"),
                            new BinaryTreeNode("0",
                                    new BinaryTreeNode("1",
                                            new BinaryTreeNode("1"),
                                            new BinaryTreeNode("1")),
                                    new BinaryTreeNode("0"))), 5)
        );
    }
}