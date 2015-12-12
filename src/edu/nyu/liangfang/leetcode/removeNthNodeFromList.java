package edu.nyu.liangfang.leetcode;

class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2(int x) {
          val = x;
          next = null;
      }
} 

public class removeNthNodeFromList {
	public ListNode2 removeNthFromEnd(ListNode2 head, int n) {    
		ListNode2 dummyHead = new ListNode2(0);
		dummyHead.next = head;		// use dummy head!!!!!
		func(dummyHead, n);
		return dummyHead.next;        
	}

	private int func(ListNode2 head, int deleteNum) {
		if (head.next == null)
			return 0;
		int num = 1 + func(head.next, deleteNum);	
		if (num == deleteNum) {			// indicating next node need to be deleted, not current node!!!
			head.next = head.next.next;		
		}
		return num;
	}
	
	public ListNode2 removeNthFromEnd2(ListNode2 head, int n) {
		ListNode2 dummyHead = new ListNode2(0);
		dummyHead.next = head;	
		ListNode2 slow = dummyHead;
		ListNode2 fast = dummyHead;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast.next != null) {
			slow = slow.next;			// do not need to worry about modify current node
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummyHead.next;
	}
	
}
