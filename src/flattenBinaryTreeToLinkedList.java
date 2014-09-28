package edu.nyu.liangfang.leetcode;

public class flattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        compute(root);
    }
    
    private TreeNode compute(TreeNode node) {
        if (node == null) 
            return null;
        
        TreeNode leftSubtree = compute(node.left);
        TreeNode rightSubtree = compute(node.right);
        if (node.left != null) {
            node.left = null;
            node.right = leftSubtree;
            TreeNode point = leftSubtree;
            while (point.right != null) {
                point = point.right;
            }
            point.right = rightSubtree;
        } 
        return node;
        
    }
}
