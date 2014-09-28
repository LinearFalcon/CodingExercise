package edu.nyu.liangfang.leetcode;

public class reverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        
        return reverse(head, k);
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode nextGroupStart = head;
        for (int i = 0; i < k; i++) {
            if (nextGroupStart == null) {   // remaining nodes' number is less than k
                return head;
            }
            nextGroupStart = nextGroupStart.next;
        }
        
        ListNode prev = head;
        ListNode point = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode next = point.next;
            point.next = prev;
            prev = point;
            point = next;
        }
        head.next = reverse(nextGroupStart, k);
        return prev;
    }
}
