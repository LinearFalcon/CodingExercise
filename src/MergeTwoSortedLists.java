package edu.nyu.liangfang.leetcode;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }


public class MergeTwoSortedLists {
	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		ListNode head;
		if (l1 == null && l2 == null) {				// Firstly you should consider null situation
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			if (l1.val >= l2.val) {			//make sure for head
				head = l2;
			} else {
				head = l1;
			}
		}
		
		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {					// Each time after comparison, we need to find the last 
				ListNode pre = l2;					// node whose value is small or equal to opposing node's value
				while (l2 != null && l2.val <= l1.val) {	
					pre = l2;
					l2 = l2.next;
				}
				pre.next = l1;
			} else {
				ListNode pre = l1;
				while (l1 != null && l1.val <= l2.val) {
					pre = l1;
					l1 = l1.next;
				}
				pre.next = l2;
			}
		}
		return head;
    }
}
