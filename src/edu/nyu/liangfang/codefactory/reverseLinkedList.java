package edu.nyu.liangfang.codefactory;

import java.util.Stack;

public class reverseLinkedList {
	// O(1) space iterative version
	public ListNode reverse_iterate(ListNode head) {
		if (head == null) return null;
		
		ListNode pre = null;
		ListNode point = head;
		while (point != null) {
			ListNode tmp = point; 
			point = point.next;
			tmp.next = pre;
			pre = tmp;
		}
		return pre;
	}
	
	// O(n) space stack version
	public ListNode reverse_stack(ListNode head) {
		if (head == null) return null;
		
		Stack<ListNode> st = new Stack<ListNode>();
		while (head != null) {
			st.push(head);
			head = head.next;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		while (!st.isEmpty()) {
			curr.next = st.pop();
			curr = curr.next;
		}
		curr.next = null;
		return dummy.next;
	}
	
	// recursion version
	public ListNode reverse_recursion(ListNode head) {
		ListNode[] newHead = new ListNode[1];
		reverse(head, newHead);
		return newHead[0];
	}
	
	
	
	private void reverse(ListNode head, ListNode[] newHead) {
		if (head == null) return;
		
		reverse(head.next, newHead);
		if (head.next != null) {
			head.next.next = head;
		} else {
			newHead[0] = head;
		}
		head.next = null;
	}

	
	
	// ------------------- test -------------------
	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(5);
		reverseLinkedList o = new reverseLinkedList();
		
		ListNode head = o.reverse_iterate(n);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
