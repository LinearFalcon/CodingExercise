public class palindromeLinkedList {
    // O(n) time O(1) space 
    public boolean isPalindrome(ListNode head) {
        ListNode left = head, right = head;
        int halfLen = 0;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            halfLen++;
        }
        if (right != null) left = left.next;
        if (halfLen == 0) return true;          // Always remember check edge case: no nodes or 1 nodes
        
        ListNode pre = left, curr = left.next;
        while (curr != null) {
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = pre;
            pre = tmp;
        }
        ListNode p = head, q = pre;
        for (int i = 0; i < halfLen; i++) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
}