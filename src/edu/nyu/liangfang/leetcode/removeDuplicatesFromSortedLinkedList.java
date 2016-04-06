public class removeDuplicatesFromSortedLinkedList {
    // my solution - two pointers
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode pre = dummyHead;
        ListNode after = head;

        while (pre != null) {
            while (after != null && pre.val == after.val) {
                after = after.next;
            }
            pre.next = after;
            pre = after;
        }
        return dummyHead.next;
    }

    // Solution2 - one pointer
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null) {
                if (node.next.val == node.val)
                    node.next = node.next.next;
                else
                    node = node.next;
            } else return head;
        }

        return head;
    }
}
