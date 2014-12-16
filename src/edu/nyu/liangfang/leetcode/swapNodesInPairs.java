package edu.nyu.liangfang.leetcode;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

public class swapNodesInPairs {
	 public ListNode2 swapPairs(ListNode2 head) {
	        ListNode2 dummyHead = new ListNode2(0);
	        dummyHead.next = head;
	        ListNode2 previous = dummyHead;
	        while (previous.next != null && previous.next.next != null) {
	            ListNode2 node1 = previous.next;
	            ListNode2 node2 = previous.next.next;
	            node1.next = node2.next;
	            node2.next = node1;
	            ListNode2 tmp = previous;
	            previous = previous.next;
	            tmp.next = node2;
	        }
	        return dummyHead.next;
	    }
}
