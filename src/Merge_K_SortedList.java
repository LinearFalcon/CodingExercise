package edu.nyu.liangfang.leetcode;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
// Must declare****************

public class Merge_K_SortedList {
	// O(N * lgK) - N total number of nodes, for each node, adding them to priority queue takes O(lgK)
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),
            new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }    
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
/*            ListNode least = queue.peek();	 Cannot just operate the node, or the priority queue
            tail.next = least;                   will not reflect correct least node!!!!!!
            least = least.next;
            tail = tail.next;
            if (least == null) {
                queue.remove(least);
            }
            */
            ListNode least = queue.poll();
            tail.next = least;
            least = least.next;
            tail = tail.next;
            if (least != null) {
                queue.add(least);
            }
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