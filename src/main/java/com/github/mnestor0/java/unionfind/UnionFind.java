package com.github.mnestor0.java.unionfind;

/*
    A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
    A union-find algorithm is an algorithm that performs two useful operations on such a data structure:
    Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.
    Union: Join two subsets into a single subset.
 */
public interface UnionFind {

    void union (int p, int q);
    int find(int p);
    boolean connected(int p, int q);
    int count();
}
