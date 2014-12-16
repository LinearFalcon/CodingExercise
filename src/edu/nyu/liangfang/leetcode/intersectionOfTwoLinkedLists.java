package edu.nyu.liangfang.leetcode;

public class intersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ap = headA;
        ListNode bp = headB; 
        int aLen = 1;
        int bLen = 1;
        
        while (ap.next != null) {
            ap = ap.next;
            aLen++;
        }
        while (bp.next != null) {
            bp = bp.next;
            bLen++;
        }
        
        if (ap != bp) {
            return null;
        }
        
        ap = headA; 
        bp = headB;
        if (aLen > bLen) {
            for (int i = 0; i < aLen - bLen; i++) {
                ap = ap.next;        
            }
        } else if (aLen < bLen) {
            for (int i = 0; i < bLen - aLen; i++) {
                bp = bp.next;        
            }
        }
        
        while (ap != bp) {
            ap = ap.next;
            bp = bp.next;
        }
        return ap;
    } 
}
