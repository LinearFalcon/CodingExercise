package edu.nyu.liangfang.leetcode;

public class MergeTwoSortedLists {

    // elegant method, using dummy head and curr pointer
    public ListNode mergeTwoLists_iterative(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1;        // important!!!
        return dummy.next;
    }

    // recursion method
    public ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_recursion(l1.next, l2);
            head = l1;
        } else {
            l2.next = mergeTwoLists_recursion(l1, l2.next);
            head = l2;
        }
        return head;
    }
}
