package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class binaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
