package edu.nyu.liangfang.leetcode;

public class reverseLinkedList2 {
	// recent version - m and n is mth and nth, not index
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);	// usually there is a dummy head 
        dummy.next = head;
        ListNode pre = dummy;
        ListNode point = head;
        
        int count = 1;
        while (count < m) {
            pre = pre.next;
            point = point.next;
            count++;
        }
        
        ListNode before = pre;
        pre = point;
        point = point.next;
        count = m + 1;  // now count means position of point
        
        while (count <= n) {
            ListNode mid = point;
            point = point.next;
            mid.next = pre;
            pre = mid;
            count++;
        }
        before.next.next = point;
        before.next = pre;
        
        return dummy.next;
    }
	
	
	
	// first version
	public ListNode reverseBetween2(ListNode head, int m, int n) {
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
