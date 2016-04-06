package edu.nyu.liangfang.leetcode;

public class partitionList {
    // -------- version 1 ----------
    public ListNode partition_v2(ListNode head, int x) {
        ListNode leftDummy = new ListNode(Integer.MIN_VALUE);
        ListNode rightDummy = new ListNode(Integer.MAX_VALUE);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        ListNode point = head;

        while (point != null) {
            if (point.val < x) {
                left.next = point;
                left = point;
            } else {
                right.next = point;
                right = point;
            }
            point = point.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }

    // version 2
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode lpoint = leftDummy;
        ListNode rpoint = rightDummy;
        ListNode point = head;

        while (point != null) {
            ListNode tmp = point;
            point = point.next;
            tmp.next = null;
            if (tmp.val < x) {
                lpoint.next = tmp;
                lpoint = tmp;
            } else {
                rpoint.next = tmp;
                rpoint = tmp;
            }
        }
        lpoint.next = rightDummy.next;
        return leftDummy.next;
    }
}
