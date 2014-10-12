package edu.nyu.liangfang.leetcode;

import java.util.Hashtable;

class Node {	
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}

// If use linkedlist to store access order, it takes O(n) time to update 
// when access one node, so we must declare a double linked list
public class LRUCache {
    private int num;
    private int capacity;
    private Node head;		
    private Node tail;		// use tail to achieve O(1) update when access one node
    private Hashtable<Integer, Node> table;
    
    public LRUCache(int capacity) {
        this.num = 0;    
        this.capacity = capacity;
        this.table = new Hashtable<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (table.containsKey(key)) {
            Node curr = table.get(key);
            update(curr);
            return curr.value;
        }
        return -1;
    }
    
    private void update(Node node) {
        if (head != tail) {         // more than one node
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                    head.pre = null;
                    
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = tail.next;
            }
        }
    }
    
    public void set(int key, int value) {
        if (table.containsKey(key)) {
            Node curr = table.get(key);
            curr.value = value;
            update(curr);
            
        } else {
            if (num == capacity) {
                table.remove(head.key);
                Node newNode = head;

                newNode.key = key;
                newNode.value = value;
                update(newNode);
                table.put(key, newNode);
            } else {
                Node newNode = new Node(key, value);
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    tail.next = newNode;
                    newNode.pre = tail;
                    tail = newNode;
                }
                
                table.put(key, newNode);
                num++;  
            } 
        }
    }
}