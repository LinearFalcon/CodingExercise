package edu.nyu.liangfang.leetcode;

public class sumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] sum = {0}; 
        compute(sum, root, new StringBuilder());
        return sum[0];
    }
    
    private void compute(int[] sum, TreeNode root, StringBuilder prevStr) {
        StringBuilder str = new StringBuilder(prevStr.toString());
        if (root.left == null && root.right == null) {
            str.append(String.valueOf(root.val));
            sum[0] += Integer.valueOf(str.toString()); 
            return;
        }
        
        str.append(String.valueOf(root.val));
        if (root.left != null) {
            compute(sum, root.left, str);
        }
        if (root.right != null) {
            compute(sum, root.right, str);
        }
    }
}
