package edu.nyu.liangfang.leetcode;
import java.util.HashMap;

class RandomListNode {
	 int label;
	 RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
};

public class copyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        
        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);
        
        // firstly process 'next' relationship
        p = p.next;
        while (p != null) {
            RandomListNode tmp = new RandomListNode(p.label);
            map.put(p, tmp);
            q.next = tmp;
            q = q.next;
            p = p.next;
        }
        
        // then process 'random' relationship, all nodes have been created now
        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null) {
                q.random = map.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}
