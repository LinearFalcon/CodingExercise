package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class sumRootToLeafNumbers {
    // version 1
    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        dfs(root, sum, 0);
        return sum[0];
    }

    private void dfs(TreeNode node, int[] sum, int curr) {
        if (node == null) return;

        curr += node.val;
        if (node.left == null && node.right == null) {
            sum[0] += curr;
            return;
        }
        dfs(node.left, sum, curr * 10);
        dfs(node.right, sum, curr * 10);
    }

    // version 2
    public int sumNumbers_2(TreeNode root) {
        return dfs_2(root, 0);
    }

    private int dfs_2(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + prev * 10;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfs_2(root.left, sum) + dfs_2(root.right, sum);
    }
}
