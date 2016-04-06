package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class binaryTreePostorderTraversal {
    // put all left node into stack first, then check peek node of stack and see if we have visited
    // its right node or its right node is null;
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode lastVisited = null;

        TreeNode node = root;
        while (!st.isEmpty() || node != null) {
            if (node != null) { // push all left nodes into stack 
                st.push(node);
                node = node.left;
            } else {            // if already pushed all left nodes, then check peeknode
                TreeNode peek = st.peek();
                // Attention!!! Here we only check peek.right, not peek!!!
                if (peek.right != null && peek.right != lastVisited) { // we haven't visit peek.right, 
                    node = peek.right;                                 // but peek.left has been visited
                } else {
                    list.add(peek.val);
                    st.pop();
                    lastVisited = peek;
                }
            }
        }

        return list;
    }
}
