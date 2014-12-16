package edu.nyu.liangfang.leetcode;
import java.util.HashMap;

class RandomListNode {
	 int label;
	 RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
};

public class copyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        if (head == null) return null;
        
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode point = head;
        while (point != null) {
            RandomListNode newNode = map.get(point);    // map will always have <point, newNode> since we process next first
            
            // firstly process 'next' relationship, and add next to map
            if (point.next != null) {
                if (map.containsKey(point.next)) {
                    newNode.next = map.get(point.next);
                } else {
                    RandomListNode next = new RandomListNode(point.next.label);
                    newNode.next = next;
                    map.put(point.next, next);
                }
            }
            // then process 'random' relationship
            if (point.random != null) {
                if (map.containsKey(point.random)) {
                    newNode.random = map.get(point.random);
                } else {
                    RandomListNode tmp = new RandomListNode(point.random.label);
                    newNode.random = tmp;
                    map.put(point.random, tmp);
                }
            }
            point = point.next;
        }
        return newHead;
    }
}
