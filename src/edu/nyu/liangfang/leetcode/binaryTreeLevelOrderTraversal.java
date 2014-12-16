package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class binaryTreeLevelOrderTraversal {
	// DFS - pre order method recursion
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        traversal(root, result, 0);
        return result;
    }
    
    public void traversal(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        
        if (result.size() < level + 1) {
            result.add(new LinkedList<Integer>());
        }
        
        result.get(level).add(root.val);
        traversal(root.left, result, level + 1);
        traversal(root.right, result, level + 1);
    }
	
    
	// BFS method - iterative
	public List<List<Integer>> levelOrder_BFS(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        
        if (root == null)
            return list;
        
        nodeQueue.add(root);
        levelQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int level = levelQueue.poll();
            
            while (list.size() < level + 1) {
                list.add(new LinkedList<Integer>());
            }
            list.get(level).add(node.val);
            
            if (node.left != null) {
                nodeQueue.add(node.left);
                levelQueue.add(level + 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                levelQueue.add(level + 1);
            }
        }
        return list;
    }
}
