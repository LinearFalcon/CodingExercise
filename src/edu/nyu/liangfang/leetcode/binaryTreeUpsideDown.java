package edu.nyu.liangfang.leetcode;

public class binaryTreeUpsideDown {
	// Iterative version
	public TreeNode UpsideDownBinaryTree_iterative(TreeNode root) {
        TreeNode parent = null;			// initialize null
        TreeNode parentRight = null;	// initialize null
        TreeNode p = root;
        while (p != null) {
            TreeNode Left = p.left; // store p.left first - start point of next loop
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = Left;
        }
        return parent;
    }
	
	// Recursion verision
	public TreeNode UpsideDownBinaryTree_recursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        while (newRoot.left != null) {	// find new root to return at the end
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
            root.left = null;		// must nullify root's left and right after reassign
            root.right = null;
        }
    }
}
