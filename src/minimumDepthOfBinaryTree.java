package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.Queue;


public class minimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<Integer> depthQ = new LinkedList<Integer>();
        nodeQ.add(root);
        depthQ.add(depth);
        
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            int num = depthQ.poll();
            if (node.left == null && node.right == null) {
                return num;
            }
            
            num++;
            if (node.left != null) {
                nodeQ.add(node.left);
                depthQ.add(num);
            }
            if (node.right != null) {
                nodeQ.add(node.right);
                depthQ.add(num);
            }
        }
        return depth;
    }
}
