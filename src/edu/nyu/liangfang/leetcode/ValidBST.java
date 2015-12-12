package edu.nyu.liangfang.leetcode;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);	// Here we assume no node has value equals to MIN_VALUE and MAX_VALUE,
    }																	// if we don't have this assumption, we can simply change to Long.MAX_VALUE and Long.MIN_VALUE
    
    public boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= min || root.val >= max) {	// must not equal, because of rule of BST!
            return false;
        }
        
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}
