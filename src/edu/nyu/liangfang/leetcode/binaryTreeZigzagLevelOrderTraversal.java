package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class binaryTreeZigzagLevelOrderTraversal {
	// DFS method - recommend
	public List<List<Integer>> zigzagLevelOrder_DFS(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        traversal(root, list, 0);
        return list;
    }
    
    public void traversal(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        
        if (list.size() < level + 1) {
            list.add(new LinkedList<Integer>());
        }
        
        if (level % 2 == 0) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);    
        }
        
        traversal(root.left, list, level + 1);
        traversal(root.right, list, level + 1);
    }
	
	// ----------- BFS method -------------
	public List<List<Integer>> zigzagLevelOrder_BFS(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        
        if (root == null)
            return list;
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<Integer> layerQ = new LinkedList<Integer>();
        nodeQ.add(root);
        layerQ.add(0);
        
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            int layer = layerQ.poll();
            
            if (list.size() < layer + 1) {
                list.add(new LinkedList<Integer>());
            }
            
            if (layer % 2 == 0) {
                list.get(layer).add(node.val);
            } else {
                list.get(layer).add(0, node.val);
            }
            
            layer++;
            if (node.left != null) {
                nodeQ.add(node.left);
                layerQ.add(layer);
            }
            if (node.right != null) {
                nodeQ.add(node.right);
                layerQ.add(layer);
            }
        }
        return list;
    }
}
