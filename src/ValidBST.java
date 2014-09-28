package edu.nyu.liangfang.leetcode;
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }


public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		boolean lvalid = true, rvalid = true;		//must first assume both left and right subtree is valid BST
		
		if (root.left != null) {
			TreeNode node = root.left;
			while (node.right != null) {		//find most right node of left subtree
				node = node.right;
			}
			if (node.val < root.val)
				lvalid = isValidBST(root.left);	// if all ok, then check if this subtree is valid BST
			else
				lvalid = false;
		} else {
			lvalid = true;
		}
		
		if (root.right != null) {
			TreeNode node = root.right;
			while (node.left != null) {			//find most left node of right subtree
				node = node.left;
			}
			if (node.val > root.val)
				rvalid = isValidBST(root.right);	// if all ok, then check if this subtree is valid BST
			else
				rvalid = false;
		} else {
			rvalid = true;
		}

		if (lvalid && rvalid) {
			return true;
		} else {
			return false;
		}
	}
}
