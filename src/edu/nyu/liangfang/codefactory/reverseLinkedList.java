package edu.nyu.liangfang.codefactory;

import java.util.Stack;

public class reverseLinkedList {
    // O(1) space iterative version - two pointer
    public ListNode reverse_iterate(ListNode head) {
        ListNode prev = null;            // Mind that prev is initialized as null
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // recursion - O(n) stack space
    public ListNode reverseList_recursion(ListNode head) {
        if (head == null) return null;

        if (head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
}
