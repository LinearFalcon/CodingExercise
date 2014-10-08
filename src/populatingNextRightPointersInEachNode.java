package edu.nyu.liangfang.leetcode;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class populatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        DFSConnect(root);
    }
    
    private TreeLinkNode DFSConnect(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        
        root.next = null;
        TreeLinkNode left = DFSConnect(root.left);
        TreeLinkNode right = DFSConnect(root.right);
        
        // always keep right nodes of left subtree and left nodes of right
        // subtree connected
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        
        return root;
    }
}
