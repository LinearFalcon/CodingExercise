package edu.nyu.liangfang.leetcode;
/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 */

public class removeDuplicatesFromSortedLinkedList2 {
    // best short method
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = null, curr = head, tail = dummy;
        while (curr != null) {
            if ((curr == head || curr.val != pre.val) && (curr.next == null || curr.val != curr.next.val)) {
                tail.next = curr;
                tail = tail.next;
            }
            pre = curr;
            curr = curr.next;
        }
        tail.next = null;                    // important!!!!!! or testcase [1,2,2] will output [1,2,2]
        return dummy.next;
    }


    // method 2: Always has two pointer points to the two new nodes that need to be checked
    public ListNode deleteDuplicates_v2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null) {
            if (fast == null || fast.val != slow.val) {
                pre.next = slow;
                pre = slow;
                slow = fast;
                if (fast != null) {
                    fast = fast.next;
                }
            } else {
                while (fast != null && fast.val == slow.val) {
                    fast = fast.next;
                }
                slow = fast;
                if (fast != null) {
                    fast = fast.next;
                }
            }
        }
        pre.next = slow;
        return dummy.next;
    }
}
