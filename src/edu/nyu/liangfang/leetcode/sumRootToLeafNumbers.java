package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class sumRootToLeafNumbers {
	// better version
	public int sumNumbers_2(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev){
        if(root == null) {
            return 0;
        }

        int sum = root.val + prev * 10;
        if(root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }
	
    
	// my version
	public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] sum = {0}; 
        compute(sum, root, "");
        return sum[0];
    }
    
    private void compute(int[] sum, TreeNode root, String prevStr) {
        if (root.left == null && root.right == null) {
            sum[0] += Integer.valueOf(prevStr + root.val); 
            return;
        }
        
        if (root.left != null) {
            compute(sum, root.left, prevStr + root.val);
        }
        if (root.right != null) {
            compute(sum, root.right, prevStr + root.val);
        }
    }
    
    // iterative version
    public int sumNumbers_iterative(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        Queue<TreeNode> traverseQ = new LinkedList<TreeNode>();
        Queue<Integer> numQ = new LinkedList<Integer>();
        traverseQ.add(root);
        numQ.add(root.val);
        
        while (!traverseQ.isEmpty()) {
            TreeNode node = traverseQ.poll();
            int preNum = numQ.poll();
            
            if (node.left == null && node.right == null) {
                sum += preNum;
                continue;
            }
            
            if (node.left != null) {
                traverseQ.add(node.left);
                numQ.add(preNum * 10 + node.left.val);
            }
            if (node.right != null) {
                traverseQ.add(node.right);
                numQ.add(preNum * 10 + node.right.val);
            }
        }
        return sum;
    }
    // iterative
    // 用 printBSTPath 里面的iterative方法
}
