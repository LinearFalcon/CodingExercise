package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class sameTree {
    // recursion version
    public boolean isSameTree_recursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return isSameTree_recursion(p.left, q.left) && isSameTree_recursion(p.right, q.right);
    }

    // iterative version - level order traverse using queue
    public boolean isSameTree_iterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> qQueue = new LinkedList<TreeNode>();

        pQueue.add(p);
        qQueue.add(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();

            if ((pNode == null && qNode != null) || (pNode != null && qNode == null)) return false;    // LinkedList and ArrayList permits Null element !!
            if (pNode == null && qNode == null) continue;
            if (pNode.val != qNode.val) return false;


            pQueue.add(pNode.left);
            qQueue.add(qNode.left);

            pQueue.add(pNode.right);
            qQueue.add(qNode.right);
        }
        return true;
    }
}
