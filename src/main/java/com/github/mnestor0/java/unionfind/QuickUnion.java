package com.github.mnestor0.java.unionfind;

/*
    For the Union Find definition please see UnionFind.java
    This is an easy implementation that allows for fast union operations.
    It is possible due to the fact that each element points to an element in the same group, not necessarily the root.
    The root points to itself.
 */
public class QuickUnion implements UnionFind {

    private final int[] sets;
    private int count;

    public QuickUnion(int n) {
        sets = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            sets[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (sets[p] != sets[q]) count--;
        sets[pRoot] = qRoot;
    }

    @Override
    public int find(int p) {
        int root = p;
        while (sets[root] != root) {
            root = sets[root];
        }
        return root;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
