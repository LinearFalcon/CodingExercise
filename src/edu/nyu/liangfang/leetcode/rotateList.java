package edu.nyu.liangfang.leetcode;

public class rotateList {
    // v1
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        
        if (len <= 1) return head;
        k %= len;
        if (k == 0) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        p = dummy; 
        ListNode q = dummy;
        for (int i = 0; i < k; i++) q = q.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        head = p.next;
        p.next = null;
        q.next = dummy.next;
        return head;
    }


    // v2
	public ListNode rotateRight_v2(ListNode head, int n) {
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
