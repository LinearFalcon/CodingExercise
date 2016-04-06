package edu.nyu.liangfang.leetcode;

/*
Given a binary tree, find the maximum path sum.

The path may start and end at any root in the tree.

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

    // maxPath return the biggest sum of path end at root
    private int maxPath(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        int left = maxPath(root.left, max);
        int right = maxPath(root.right, max);
        int sumAcrossRoot = root.val + left + right;    // sum of path across current root root
        int sumEndAtRoot = Math.max(root.val, root.val + Math.max(left, right));    // biggest sum of path end at root
        max[0] = Math.max(max[0], Math.max(sumAcrossRoot, sumEndAtRoot));
        return sumEndAtRoot;
    }
}
