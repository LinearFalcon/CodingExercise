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
	
	// O(n) time O(1) space (no extra space)
	public void reorderList_noExtraSpace(ListNode head) {
        if (head == null) return;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        // reverse second half
        ListNode pre = null;
        ListNode point = head2;
        while (point != null) {
            ListNode mid = point;
            point = point.next;
            mid.next = pre;
            pre = mid;
        }
        ListNode l2 = pre;
        ListNode l1 = head;
        
        // merge two lists
        while (l1 != null && l2 != null) {
            ListNode tmp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = tmp;
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
