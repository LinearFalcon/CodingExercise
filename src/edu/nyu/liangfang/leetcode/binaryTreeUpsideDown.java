package edu.nyu.liangfang.leetcode;

public class binaryTreeUpsideDown {
    // Iterative version
    public TreeNode UpsideDownBinaryTree_iterative(TreeNode root) {
        TreeNode parent = null;            // initialize null
        TreeNode parentRight = null;    // initialize null
        TreeNode p = root;
        while (p != null) {
            TreeNode right = p.right;    // store p.left and p.right first
            TreeNode left = p.left;
            p.right = parent;
            parent = p;
            p.left = parentRight;
            parentRight = right;
            p = left;
        }
        return parent;
    }

    // Recursion verision
    public TreeNode UpsideDownBinaryTree_recursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        while (newRoot.left != null) {    // find new root to return at the end
            newRoot = newRoot.left;
        }

        modify(root);
        return newRoot;
    }

    public void modify(TreeNode root) {
        if (root == null) {
            return;
        }

        modify(root.left);
        if (root.left != null) {
            root.left.right = root;
            root.left.left = root.right;
            root.left = null;        // must nullify root's left and right after reassign
            root.right = null;
        }
    }
}
