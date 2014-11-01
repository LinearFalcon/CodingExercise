package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class pathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        
        if (root == null)
            return list;
        
        int currentSum = 0;
        compute(root, list, path, currentSum, sum);
        return list;
    }
    
    private void compute(TreeNode root, List<List<Integer>> list, List<Integer> path, int currentSum, int sum) {
        List<Integer> tmp = new LinkedList<Integer>(path);
        
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                tmp.add(root.val);
                list.add(tmp);
                return;
            }
        }
            
        currentSum += root.val;
        tmp.add(root.val);
        if (root.left != null) {
            compute(root.left, list, tmp, currentSum, sum);
        }
        if (root.right != null) {
            compute(root.right, list, tmp, currentSum, sum);
        }
    }
}
