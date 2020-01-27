package com.github.mnestor0.java.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {
    private static final int n = 10;
    private List<UnionFind> implementations;

    @BeforeEach
    void setUp() {
        implementations = new ArrayList<>();
        implementations.add(new QuickFind(n));
        implementations.add(new QuickUnion(n));
        implementations.add(new WeightedQuickUnion(n));
        implementations.add(new WeightedQuickUnionWithPathCompression(n));
    }

    @Test
    void testIfSymmetric() {
        for (UnionFind find : implementations) {
            assertFalse(find.connected(0, 1));
            assertFalse(find.connected(1, 0));
            find.union(0, 1);
            assertTrue(find.connected(0, 1));
            assertTrue(find.connected(1, 0));
        }
    }

    @Test
    void testCount() {
        for (UnionFind find : implementations) {
            assertEquals(10, find.count());
            find.union(0, 1);
            assertEquals(9, find.count());
            find.union(0, 1);
            assertEquals(9, find.count());
            find.union(1, 2);
            assertEquals(8, find.count());
            find.union(8, 9);
            assertEquals(7, find.count());
            find.union(2, 8);
            assertEquals(6, find.count());
            find.union(2, 8);
            assertEquals(6, find.count());
        }
    }

    @Test
    void testIfReflexive() {
        for (UnionFind find : implementations) {
            assertTrue(find.connected(0, 0));
            assertTrue(find.connected(1, 1));
        }
    }

    @Test
    void testIfTransitive() {
        for (UnionFind find : implementations) {
            assertFalse(find.connected(0, 1));
            assertFalse(find.connected(1, 2));
            find.union(0, 1);
            find.union(1, 2);
            assertTrue(find.connected(0, 1));
            assertTrue(find.connected(1, 2));
            assertTrue(find.connected(0, 2));
        }
    }

    @Test
    void bookExample() {
        for (UnionFind find : implementations) {
            assertFalse(find.connected(4, 3));
            find.union(4, 3);
            assertFalse(find.connected(3, 8));
            find.union(3, 8);
            assertFalse(find.connected(6, 5));
            find.union(6, 5);
            assertFalse(find.connected(9, 4));
            find.union(9, 4);
            assertFalse(find.connected(2, 1));
            find.union(2, 1);
            assertTrue(find.connected(8, 9));
            find.union(8, 9);
            assertFalse(find.connected(5, 0));
            find.union(5, 0);
            assertFalse(find.connected(7, 2));
            find.union(7, 2);
            assertFalse(find.connected(6, 1));
            find.union(6, 1);
            assertTrue(find.connected(1, 0));
            assertTrue(find.connected(6, 7));
            assertFalse(find.connected(2, 3));
            assertFalse(find.connected(7, 8));
            assertEquals(2, find.count());
        }
    }
}