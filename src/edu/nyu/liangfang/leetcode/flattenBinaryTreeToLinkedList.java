package edu.nyu.liangfang.leetcode;

import java.util.Stack;

// Simple flatten method
class Solution2 {
	private TreeNode lastNode = null;		
 
	public void flatten_PreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
     
		if (lastNode != null) {		// if have lastNode, then link lastNode with current root(head)
			lastNode.left = null;
			lastNode.right = root;
		} 
		lastNode = root;
     
		TreeNode right = root.right;
		flatten_PreOrder(root.left);		
		flatten_PreOrder(right);
	}
	
	// In order flatten - Not for Leetcode OJ
	public void flatten_InOrder(TreeNode root) {
		if (root == null)
			return;
		
		flatten_InOrder(root.left);
		
		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root;
		
		flatten_InOrder(root.right);
	}
}


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
      
    // iterative solution
    // Go down through the left, when right is not null, push right to stack.
    public void flatten_iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
 
        while(p != null || !stack.empty()){
 
            if(p.right != null){
                stack.push(p.right);
            }
 
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }
 
            p = p.right;
        }
    }
}


