package edu.nyu.liangfang.leetcode;
/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 */

public class removeDuplicatesFromSortedLinkedList2 {
	public ListNode deleteDuplicates(ListNode head) {
//      ListNode dummy = null;			cannot assign a int variable to null; also do not assign a object to null and then call its members
      ListNode dummy = new ListNode(Integer.MAX_VALUE);		// use max int value as dummy head value
      dummy.next = head;
      ListNode prev = dummy;
      ListNode point = head;
      ListNode tail = dummy;
      
      while (point != null) {
          if ( (point.val != prev.val) && (point.next == null ? true : point.val != point.next.val) ) {
              tail.next = point;
              tail = tail.next;
          } 
          point = point.next;
          prev = prev.next;
      }
      tail.next = null;
      return dummy.next;
  }
}
