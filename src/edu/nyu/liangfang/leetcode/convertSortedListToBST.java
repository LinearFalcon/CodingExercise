package edu.nyu.liangfang.leetcode;

public class convertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null || head.val == Integer.MAX_VALUE)
            return null;
        
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode fast = head;
        ListNode mid = head;
        ListNode prev = dummy;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
            prev = prev.next;
        }
        prev.next = null;
        
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(dummy.next);
        node.right = sortedListToBST(mid.next);
        
        return node;
    }
}
