package com.github.mnestor0.java.unionfind;

/*
    For the Union Find definition please see UnionFind.java
    This is an easy implementation that allows for fast find operations.
    It is possible due to the fact that each element points to the root of the current set.
 */
public class QuickFind implements UnionFind {

    private final int[] sets;
    private int count;

    public QuickFind(int n) {
        sets = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            sets[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if (sets[p] != sets[q]) count--;
        int old = sets[p];
        for (int i = 0; i < sets.length; i++) {
            if (sets[i] == old) {
                sets[i] = sets[q];
            }
        }
    }

    @Override
    public int find(int p) {
        return sets[p];
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
