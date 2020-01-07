package com.github.mnestor0.java.exercises;

import java.util.HashMap;
import java.util.Map;

/*
    This problem was asked by Google.
    An XOR linked list is a more memory efficient doubly linked list.
    Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node.
    Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
    If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions
    that converts between nodes and memory addresses.

    Solution:
    XOR has an interesting quality -> a ^ a = 0 and going further a ^ b ^ a = b.
    This can be used for fetching list nodes sequentially. For example:
    First node has address 'a'.
    Second node has address 'b'.
    Third node has address 'c'.
    First node's 'both' property contains only next element: 'b'.
    Second node has 'both' property = 'a ^ c'. We know that previous node of the second node has address 'a', so to get
    the address of the next node we have to XOR 'both' property with previous element address => '(a ^ c) ^ a' = c.
    Same can be applied to find previous nodes (iterating from last element to the first.
 */
public class XORLinkedList {

    public static void main(String[] args) {
        XORLinkedList xorLinkedList = new XORLinkedList();
        xorLinkedList.add(1234);
        xorLinkedList.add(2345);
        xorLinkedList.add(3456);
        System.out.println(xorLinkedList.get(0));
        System.out.println(xorLinkedList.get(1));
        System.out.println(xorLinkedList.get(2));
    }

    private final Map<Integer, Node> nodesByAddress = new HashMap<>();

    private int first;
    private int size;

    private void add(int newAddress) {
        Node newNode = new Node(newAddress);
        nodesByAddress.put(newAddress, newNode);
        if (first == 0) {
            first = newAddress;
        } else {
            int prev = 0;
            Node lastNode = nodesByAddress.get(first);
            int next = lastNode.both ^ prev;
            while(next != 0) {
                prev = lastNode.address;
                lastNode = nodesByAddress.get(next);
                next = lastNode.both ^ prev;
            }
            lastNode.both ^= newAddress;
            newNode.both ^= lastNode.address;
        }
        size++;
    }

    private int get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException();
        }
        Node lastNode = nodesByAddress.get(first);
        int prev = 0;
        int next = lastNode.both ^ prev;
        for(int i = 0; i < index; i++) {
            prev = lastNode.address;
            lastNode = nodesByAddress.get(next);
            next = lastNode.both ^ prev;
        }
        return lastNode.address;
    }


    private static class Node {
        final int address;
        int both;

        private Node(int address) {
            this.address = address;
        }
    }
}
