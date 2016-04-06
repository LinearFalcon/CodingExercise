package edu.nyu.liangfang.leetcode;

import java.util.Stack;

public class reorderList {

    // O(n) time O(n) space
    public void reorderList_sol1(ListNode head) {
        if (head == null)
            return;
        Stack<ListNode> st = new Stack<ListNode>();    // stack store last half of nodes
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
        while (point != null) {        // push nodes in last half into stack
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

    // O(n) time O(1) space (no extra space!!)
    public void reorderList_noExtraSpace(ListNode head) {
        if (head == null) return;

        ListNode dummy = new ListNode(0);    // MUST use dummy to make slow always point to middle one (odd number) or last of first half (even number)
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse second half
        ListNode prev = null;
        while (head2 != null) {
            ListNode tmp = head2;
            head2 = head2.next;
            tmp.next = prev;
            prev = tmp;
        }

        ListNode p = head;
        ListNode q = prev;
        while (p != null && q != null) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = q;
            q = q.next;
            tmp.next.next = p;
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
