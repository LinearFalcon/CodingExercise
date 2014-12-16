package edu.nyu.liangfang.leetcode;

import java.util.HashMap;

/*
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
*/

//If use linkedlist to store access order, it takes O(n) time to update 
//when access one node, so we must declare a double linked list
public class LRUCache_short {
    private HashMap<Integer, Node> map;		// use map to implement O(1) get
    private int capacity;
    private Node tail;	// dummy tail, the node after last node
    private Node head;	// dummy head, the node before first node
    
    public LRUCache_short(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        tail = new Node(-1, -1);
        head = new Node(-1, -1);
        head.next = tail;			// This is important initialization!!!
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;	// remove current node from original position
            node.next.prev = node.prev;
            insertToTail(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
        	map.get(key).val = value;
        } else {
        	if (map.size() == capacity) {	// if reach capacity, delete current first node
        		map.remove(head.next.key);
        		head.next = head.next.next;
        		head.next.prev = head;
        	}
        	
        	Node newNode = new Node(key, value);
        	map.put(key, newNode);
        	insertToTail(newNode);
        }
    }
    
    // move node to the tail of the list, right before dummy tail node
    public void insertToTail(Node node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev.next = node;
    }
}