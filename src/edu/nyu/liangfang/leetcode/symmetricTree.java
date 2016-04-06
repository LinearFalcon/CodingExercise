package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class symmetricTree {
    // Recursion method
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

        } else {
            return false;
        }
    }

    // -------- Iterative method --------
    public boolean isSymmetric_iterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> leftQ = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQ = new LinkedList<TreeNode>();
        leftQ.add(root.left);
        rightQ.add(root.right);

        while (!leftQ.isEmpty() && !rightQ.isEmpty()) {
            TreeNode left = leftQ.poll();
            TreeNode right = rightQ.poll();
            if ((left == null && right != null) || (left != null && right == null)) {
                return false;
            } else if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                leftQ.add(left.left);
                leftQ.add(left.right);
                rightQ.add(right.right);
                rightQ.add(right.left);
            } else {    // both is null
                continue;
            }
        }
        return true;
    }
}
