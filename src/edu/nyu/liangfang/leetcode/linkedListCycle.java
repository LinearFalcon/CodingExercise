package edu.nyu.liangfang.leetcode;

public class linkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null) {
            if (p1 == p2) return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
