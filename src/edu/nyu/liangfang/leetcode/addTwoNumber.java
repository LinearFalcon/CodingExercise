package edu.nyu.liangfang.leetcode;

public class addTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1;
        int n2;
        int carry = 0;
        ListNode point = new ListNode(0);
        ListNode dummyhead = point;
        while (l1 != null || l2 != null || carry != 0) {
            n1 = (l1 != null) ? l1.val : 0;
            n2 = (l2 != null) ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            point.next = new ListNode(sum);
            point = point.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyhead.next;
    }
}
