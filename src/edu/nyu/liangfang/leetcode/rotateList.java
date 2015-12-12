package edu.nyu.liangfang.leetcode;

public class rotateList {
	public ListNode rotateRight(ListNode head, int n) {
        ListNode last = null;
        int length = 0;
        ListNode point = head;
        while (point != null) {
            length++;
            last = point;
            point = point.next;
        }
        
        // n may be 0 or bigger than length
        if (n == 0 || head == null)
            return head;
        if (n >= length) {
            n = n % length;
            if (n == 0)
                return head;
        }
        
        ListNode newHead = head;
        ListNode newTail = head;
        for (int i = 0; i < length - n - 1; i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = last.next;
        last.next = head;
        return newHead;
    }
}
