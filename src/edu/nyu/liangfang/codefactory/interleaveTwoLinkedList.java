package edu.nyu.liangfang.codefactory;

/*
interleave two linked-list
for example
Given
1->2->3->4;
5->6;
return 1->5->2->6->3->4;
 */
public class interleaveTwoLinkedList {
    public ListNode interleave_recursion(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        n1.next = interleave_recursion(n2, n1.next);
        return n1;
    }

    public ListNode interleave_iterative(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (n1 != null) {
            curr.next = n1;
            n1 = n2;
            curr = curr.next;
            n2 = curr.next;
        }
        return dummy.next;
    }
}
