public class oddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode oddTail = oddDummy, evenTail = evenDummy;
        int count = 1;
        while (head != null) {
            if (count % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
            count++;
        }
        evenTail.next = null;               // Always remember to set last right tail's next to null!!
        oddTail.next = evenDummy.next;
        return oddDummy.next;
    }
}