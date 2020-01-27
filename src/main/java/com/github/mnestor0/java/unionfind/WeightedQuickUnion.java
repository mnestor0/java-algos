package com.github.mnestor0.java.unionfind;

/*
    For the Union Find definition please see UnionFind.java
    This is an easy implementation that allows for fast union operations.
    It is possible due to the fact that each element points to an element in the same group, not necessarily the root.
    The root points to itself.
    To help balance the trees during unions, the size of each tree is stored. During union always the smaller
    tree is connected to the larger tree.
 */
public class WeightedQuickUnion implements UnionFind {

    private final int[] sets;
    private final int[] sizes;
    private int count;

    public WeightedQuickUnion(int n) {
        sets = new int[n];
        sizes = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            sets[i] = i;
            sizes[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        int pSize = sizes[pRoot];
        int qSize = sizes[qRoot];
        if (pSize < qSize) {
            sets[pRoot] = qRoot;
            sizes[qRoot] += pSize;
        } else {
            sets[qRoot] = pRoot;
            sizes[pRoot] += qSize;
        }
        count--;
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
