package edu.nyu.liangfang.leetcode;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
// Must declare****************

public class Merge_K_SortedList {
	// O(N * lgK) - N total number of nodes, for each node, adding them to priority queue takes O(lgK)
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (ListNode n : lists) {
            if (n != null) queue.offer(n);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) queue.offer(node.next);
        }
        return dummy.next;
    }
    
    
    
    // Divide and Conquer - TLE
    public ListNode mergeKLists_DivideAndConquer(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        int mid = lists.size() / 2;
        ListNode n1 = merge(lists, 0, mid);
        ListNode n2 = merge(lists, mid + 1, lists.size() - 1);
        return mergeTwoSortedList(n1, n2);
    }
    
    public ListNode merge(List<ListNode> lists, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return lists.get(start);
        }
        
        int mid = (start + end) / 2;
        return mergeTwoSortedList(merge(lists, 0, mid), merge(lists, mid + 1, end));
    }
    
    public ListNode mergeTwoSortedList(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }
        tail.next = (n1 == null ? n2 : n1);
        return dummy.next;
    }
}