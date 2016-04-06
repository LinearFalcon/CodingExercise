package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;

// v1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution_v2 {
    private TreeNode prev = null;
    private TreeNode left = null;
    private TreeNode right = null;
    private boolean firstMet = true;

    public void recoverTree(TreeNode root) {
        dfs(root);

        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (prev != null && root.val < prev.val) {
            if (firstMet) {
                right = root;
                left = prev;
                firstMet = false;
            } else {
                right = root;
            }
        }
        prev = root;
        dfs(root.right);
    }
}

// v2
public class recoverBST {
    // constant space method
    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[2];        // must use array rather than pass TreeNode first and second !!!!!!!
        TreeNode[] pre = {new TreeNode(Integer.MIN_VALUE)};
        int[] count = {0};                // count to find two swapped nodes
        traversal(root, nodes, pre, count);    // in-order traversal

        int tmp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tmp;
    }

    public void traversal(TreeNode root, TreeNode[] nodes, TreeNode[] pre, int[] count) {
        if (root == null) {
            return;
        }

        traversal(root.left, nodes, pre, count);
        if (root.val < pre[0].val) {
            if (count[0] == 0) {
                nodes[0] = pre[0];
                nodes[1] = root;
                count[0]++;
            } else {
                nodes[1] = root;
            }
        }
        pre[0] = root;
        traversal(root.right, nodes, pre, count);
    }


    // O(n) space
    public void recoverTree1(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        BST2Arr(root, arr);
        TreeNode first = null;
        TreeNode second = null;
        int count = 0;
        int firstIndex = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val < arr.get(i - 1).val) {
                if (count == 0) {
                    first = arr.get(i - 1);
                    firstIndex = i - 1;
                    count++;
                } else {
                    second = arr.get(i);
                }
            }
        }
        // handle when adjacent nodes in the in-order traversal arraylist are swapped
        // because if so, second would be null after the for loop, so we need to fix it
        if (second == null)
            second = arr.get(firstIndex + 1);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void BST2Arr(TreeNode root, ArrayList<TreeNode> arr) {
        if (root == null)
            return;
        BST2Arr(root.left, arr);
        arr.add(root);
        BST2Arr(root.right, arr);
    }

}
