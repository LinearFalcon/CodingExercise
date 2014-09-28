package edu.nyu.liangfang.leetcode;

public class reverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode prev = dummy;
        ListNode start = head;
        ListNode point = head;
        
        int count = 1;
        boolean findStart = false;
        while (count <= n) {
            if (count == m) {
                start = point;    
                preStart = prev;
                
                prev = prev.next;
                point = point.next;
                count++;
                findStart = true;
                continue;
            } else if (count < m) {
                prev = prev.next;
                point = point.next;
            }
            
            if (findStart) {
                ListNode tmp = point; 
                point = point.next;
                tmp.next = prev;
                prev = tmp;
            }
            
            count++;
        }
        start.next = point;
        preStart.next = prev;
        
        return dummy.next;
    }
}
