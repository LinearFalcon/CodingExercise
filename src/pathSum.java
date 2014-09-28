package edu.nyu.liangfang.leetcode;

public class pathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int currentSum = 0;
        return hasPathSum(root, currentSum, sum);
    }
    
    private boolean hasPathSum(TreeNode node, int currentSum, int sum) {
        if (node.left == null && node.right == null) {		// when node is leaf, check the sum
            if (currentSum + node.val == sum)
                return true;
            return false;
        }
        
        currentSum += node.val;
        if (node.left != null && hasPathSum(node.left, currentSum, sum))	// only proceed to left when left is not null
            return true;
        if (node.right != null && hasPathSum(node.right, currentSum, sum))	// only proceed to right when right is not null
            return true;
        return false;
    }
}
