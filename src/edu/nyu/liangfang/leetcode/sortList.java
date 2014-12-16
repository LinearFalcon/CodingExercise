package edu.nyu.liangfang.leetcode;

public class sortList {
	/*
	 * Merge Sort
	 */
	public ListNode MergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = getMiddle(head);
        ListNode half = middle.next;
        middle.next = null;
        
        return merge(MergeSort(head), MergeSort(half));
    }
    
    private ListNode getMiddle(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode quick = dummy;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        curr.next = (node1 == null) ? node2 : node1;
        return dummy.next;
    }
    
    /*
     * Quick Sort
     */
    
}
