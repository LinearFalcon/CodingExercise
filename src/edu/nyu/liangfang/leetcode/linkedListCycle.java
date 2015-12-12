package edu.nyu.liangfang.leetcode;

public class linkedListCycle {
	public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }
        
        if (p2 != null && p2.next != null) 
        	return true;
        else 
        	return false;
    }
}
