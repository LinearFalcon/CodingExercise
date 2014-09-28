package edu.nyu.liangfang.leetcode;

public class partitionList {
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
