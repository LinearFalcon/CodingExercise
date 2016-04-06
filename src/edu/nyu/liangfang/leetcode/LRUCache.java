package edu.nyu.liangfang.leetcode;

import java.util.HashMap;

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//If use linkedlist to store access order, it takes O(n) time to update 
//when access one node, so we must declare a double linked list
public class LRUCache {
    private HashMap<Integer, Node> map;        // use map to implement O(1) get
    private int capacity;
    private Node tail;    // use tail to achieve O(1) update when access one node
    private Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToTail(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            if (map.size() < capacity) {
                Node newNode = new Node(key, value);
                if (map.size() == 0) {          // must consider empty condition
                    head = newNode;
                } else {
                    newNode.prev = tail;
                    tail.next = newNode;
                }
                tail = newNode;
                map.put(key, newNode);
            } else {
                map.remove(head.key);
                Node node = head;
                node.val = value;
                node.key = key;
                moveToTail(node);
                map.put(key, node);
            }
        }
    }

    // move node to the tail of the list
    public void moveToTail(Node node) {
        if (node != tail) {            // if node is tail, don't need to update
            node.next.prev = node.prev;

            if (node.prev != null) {    // if current head is node
                node.prev.next = node.next;
            }

            if (node.prev == null) { // if current head is node
                head = head.next;
            }
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }
}