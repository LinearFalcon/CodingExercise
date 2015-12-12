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
     
		TreeNode right = root.right;	// MUST! Because after flatten(root.left), root.right will be pointed to original root.left
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
    // iterative solution - stack to achieve pre-order traversal, then use 'last'
    public void flatten_iterative(TreeNode root) {
    	if (root == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode last = null;
        st.push(root);
        
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (last != null) {
                last.left = null;
                last.right = node;
            }
            last = node;
            
            if (node.right != null)
                st.push(node.right);
            if (node.left != null)
                st.push(node.left);
        }
    }
}


