package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;

/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 */

public class uniqueBinarySearchTree2 {
	public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    
	// the recursion function returns a list of tree node that each of them represents a unique BST
	public List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        if (start > end) {
            result.add(null);		// must add null!!!
            return result;
        }
        
        for (int i = start; i <= end; i++) {
            for (TreeNode l : generate(start, i - 1)) {
                for (TreeNode r : generate(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
