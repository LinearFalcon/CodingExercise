package edu.nyu.liangfang.leetcode;
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }


public class ValidBST {
	public boolean isValidBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
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
