package edu.nyu.liangfang.codefactory;

import java.util.Stack;

import edu.nyu.liangfang.leetcode.TreeNode;

public class printBSTPath {
	public void printIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            System.out.print(node.val);
            if (node.left == null && node.right == null) {
            	System.out.println();
            }
            
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
    }
}
