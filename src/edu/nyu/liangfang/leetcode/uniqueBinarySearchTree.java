package edu.nyu.liangfang.leetcode;
/*
假设给定n个节点，节点值为1,2,3...,n，求由这些结点可以构成多少棵不同的二叉查找树。

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
思路：递归，由于是二叉查找树，先选择任一结点根结点，假设为结点i，则[1，i-1]范围的结点为结点i的左子树结点，[i+1，n]范围的
	结点为结点i的右子树结点，则以结点i为根结点的BST个数为左，右子树可构成BST个数的乘积，基于这个思路，可以写出以下递归程序。 
 */

public class uniqueBinarySearchTree {
	// Recursion version 1
	public int numTrees(int n) {
        if (n == 0) return 1;
        
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += numTrees(i - 1) * numTrees(n - i);
        }
        return num;
    }
	
	// Recursion version 2
	public int numTrees_2(int n) {
        return numTrees(1, n);
    }
    
    private int numTrees(int start, int end) {
        if (start >= end)
            return 1;
        
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += numTrees(start, i - 1) * numTrees(i + 1, end);
        }
        return sum;
    }
}
