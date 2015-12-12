package edu.nyu.liangfang.leetcode;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class populatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        connect(left);
        connect(right);
        
        while (left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}
