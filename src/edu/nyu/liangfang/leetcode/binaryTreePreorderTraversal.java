package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class binaryTreePreorderTraversal {
    // The key to solve this problem is using a stack to store left and
    // right children: Visit root, then push root.right into stack and then
    // push root.left into stack, then pop out and visit and repeat previous operation
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return list;
    }
}
