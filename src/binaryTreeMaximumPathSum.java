package edu.nyu.liangfang.leetcode;

/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

 */

public class binaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPath(root, max);
        return max[0];
    }
    
	// maxPath return the biggest sum of path end at node
    private int maxPath(TreeNode node, int[] max) {
        if (node == null)
            return 0;
        
        int left = maxPath(node.left, max);
        int right = maxPath(node.right, max);
        int sumAcrossRoot = node.val + left + right;	// sum of path across current root node
        int single = Math.max(node.val, node.val + Math.max(left, right));	// biggest sum of path end at node
        max[0] = Math.max(max[0], Math.max(sumAcrossRoot, single));
        return single;
    }
}
