package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pathSum2 {
	// simple version
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        compute(rst, curr, root, sum);
        return rst;
    }
    
    public void compute(List<List<Integer>> rst, List<Integer> curr, TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                curr.add(root.val);
                rst.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        
        curr.add(root.val);
        compute(rst, curr, root.left, sum);
        compute(rst, curr, root.right, sum);
        curr.remove(curr.size() - 1);
    }
	
	
	// my version
	public List<List<Integer>> pathSum_me(TreeNode root, int sum) {
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
