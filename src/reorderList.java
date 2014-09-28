package edu.nyu.liangfang.leetcode;

import java.util.Stack;

public class reorderList {
	
	// O(n) time O(n) space
	public void reorderList_sol1(ListNode head) {
        if (head == null)
            return;
        Stack<ListNode> st = new Stack<ListNode>();	// stack store last half of nodes
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode point = slow.next;
        slow.next = null;
        while (point != null) {		// push nodes in last half into stack
            st.push(point);
            point = point.next;
        }
        
        point = head; 
        while (!st.isEmpty()) {
            ListNode last = st.pop();
            last.next = point.next;
            point.next = last;
            point = last.next;
        }
    }
	
	
	// Time Limit Exceed solution - not necessary
	public void reorderList_sol2(ListNode head) {
        if (head == null)
            return;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = head;
        ListNode prev = dummy;
        while (last.next != null) {
            last = last.next;
            prev = prev.next;
        }
        
        if (head.next == null || head.next == last) {
            return;
        }
        prev.next = null;
        last.next = head.next;
        head.next = last;
        
        reorderList_sol2(last.next);
    }
}
