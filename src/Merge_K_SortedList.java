package edu.nyu.liangfang.leetcode;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;		// Must declare****************

public class Merge_K_SortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {		//	O(N * lgK)
        if (lists.isEmpty())
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {	// Look out how to declare PriorityQueue!******
                public int compare(ListNode a, ListNode b) {
                    if (a.val > b.val)
                        return 1;
                    else if (a.val == b.val)
                        return 0;
                    else
                        return -1;
                }
            });
        
        for (ListNode node : lists) {       // add all head nodes of k lists into priority queue
            if (node != null)           // must make sure! When list is null, meaning this lists'
                q.add(node);            // elements are all processed
        }
        
        ListNode head = new ListNode(0); // dummy head
        ListNode pre = head;
        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            pre.next = temp;
            if (temp.next != null) {
                temp = temp.next;
                q.add(temp);
            }
            pre = pre.next;
        }
        return head.next;
    }
}