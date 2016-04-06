package edu.nyu.liangfang.leetcode;

public class removeNthNodeFromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;        // use dummy head!!!!!
        func(dummyHead, n);
        return dummyHead.next;
    }

    private int func(ListNode head, int deleteNum) {
        if (head.next == null)
            return 0;
        int num = 1 + func(head.next, deleteNum);
        if (num == deleteNum) {            // indicating next node need to be deleted, not current node!!!
            head.next = head.next.next;
        }
        return num;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;            // do not need to worry about modify current node
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

}
