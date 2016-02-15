public class removeLinkedListElements {
	// iterative
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;				// only move to next if not equal to val
        }
        return dummy.next;
    }

    //recursion
    public ListNode removeElements_recur(ListNode head, int val) {
        if (head == null) return null;
        else if (head.val == val) return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}