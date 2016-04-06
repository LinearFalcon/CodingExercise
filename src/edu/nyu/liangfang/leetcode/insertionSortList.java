package edu.nyu.liangfang.leetcode;

public class insertionSortList {
    public ListNode insertionSortListSol(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode point = head;

        while (point != null) {
            if (prev.val > point.val) {
                ListNode curr = point;
                point = point.next;

                ListNode runner = dummy;
                while (runner.next.val < curr.val) {
                    runner = runner.next;
                }
                prev.next = curr.next;
                curr.next = runner.next;
                runner.next = curr;
            } else {
                point = point.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
