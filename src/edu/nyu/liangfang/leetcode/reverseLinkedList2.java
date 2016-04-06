package edu.nyu.liangfang.leetcode;

public class reverseLinkedList2 {
    // recent version - m and n is mth and nth, not index
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode before = dummyHead;
        for (int i = 0; i < m - 1; i++) before = before.next;

        ListNode pre = before;
        ListNode curr = before.next;
        for (int i = 0; i <= n - m; i++) {
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = pre;
            pre = tmp;
        }
        before.next.next = curr;
        before.next = pre;
        return dummyHead.next;
    }
}
