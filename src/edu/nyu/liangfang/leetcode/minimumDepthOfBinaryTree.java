package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.Queue;


public class minimumDepthOfBinaryTree {
	// simple Recursion method, similar to Maximum Depth of Binary Tree
	public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;
        return getMin(root);
    }
    
    public int getMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        return 1 + Math.min(getMin(node.left), getMin(node.right));
    }

    // DFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int[] minDepth = {Integer.MAX_VALUE};
        compute(root, 0, minDepth);
        return minDepth[0];
    }
    
    private void compute(TreeNode root, int dep, int[] minDepth) {
        dep++;
        if (dep >= minDepth[0]) return;
        if (root.left == null && root.right == null) {
            if (dep < minDepth[0]) minDepth[0] = dep;
            return;
        }
        
        if (root.left != null) compute(root.left, dep, minDepth);
        if (root.right != null) compute(root.right, dep, minDepth);
    }
	
	
	// BFS
	public int minDepth_BFS(TreeNode root) {
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
