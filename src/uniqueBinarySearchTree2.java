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
        if (n == 0) {
            List<TreeNode> list = new LinkedList<TreeNode>();
            list.add(null);
            return list;
        }
        return generate(1, n);
    }
    
	// the recursion function returns a list of tree node that each of them represents a unique BST
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        } else if (start > end) {
            list.add(null);
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generate(start, i - 1);
            List<TreeNode> rightNodes = generate(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);	// must create a new object 
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
