package edu.nyu.liangfang.codefactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import edu.nyu.liangfang.leetcode.TreeNode;


public class printBSTPath {
	// recursion
	public void printRecursion(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		print(root, list);
	}
	
	private void print(TreeNode root, List<Integer> list) {
		if (root == null) return;
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			list.remove(list.size() - 1);
			return;
		}
		
		list.add(root.val);
		print(root.left, list);
		print(root.right, list);
		list.remove(list.size() - 1);
	}
	
	
	// iterative - DFS and print stack when encounter leaf
	public void printIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        
        Set<TreeNode> visited = new HashSet<TreeNode>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.peek();
            visited.add(top);
            if (top.left != null && !visited.contains(top.left)) {
            	st.push(top.left);
            } else if (top.right != null && !visited.contains(top.right)) {
            	st.push(top.right);
            } else {
            	if (top.left == null && top.right == null) {
            		printStack(st);
            	}
            	st.pop();
            }
        }
    }
	
	private void printStack(Stack<TreeNode> st) {
		for (int i = 0; i < st.size(); i++) {
			System.out.print(st.elementAt(i).val);
		}
		System.out.println();
	}

	/*
	 * 现在不仅要打印路径，还要把树的形状打印出来，
   		A
  	  B   C
	D    E  F

	例如ABD要打印成
	(空格)(空格)A
	(空格)B
	D
	ACE要打印成
	A
	(空格)C
	E 
	 */

	// 在DFS的时候多加一个vector，记录当前缩进深度，以根节点A为0作参考，左节点减1右结点加1
	// 然后打印的时候找出当前vector最小值，然后对于每个值，减去这个最小值，算出要在左边加多少个空格
	public void printWithIdention(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> inden = new ArrayList<Integer>();
		inden.add(0);				// 提前initialize root对应的indention是0
		print(root, list, inden);
	}
	
	private void print(TreeNode root, List<Integer> list, List<Integer> inden) {
		if (root == null) return;
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
			
			int min = findMin(inden);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < inden.get(i) - min; j++) {
					System.out.print(" ");
				}
				System.out.println(list.get(i));
			}
			System.out.println();
			list.remove(list.size() - 1);
			return;
		}
		
		list.add(root.val);
		
		inden.add(inden.get(inden.size() - 1) - 1);
		print(root.left, list, inden);
		inden.remove(inden.size() - 1);
		
		inden.add(inden.get(inden.size() - 1) + 1);
		print(root.right, list, inden);
		inden.remove(inden.size() - 1);
		
		list.remove(list.size() - 1);
	}
	
	private int findMin(List<Integer> inden) {
		int min = 0;
		for (int i : inden) {
			min = Math.min(min, i);
		}
		return min;
	}

	
	
	// -------------------- test --------------------
	public static void main(String[] args) {
		printBSTPath o = new printBSTPath();
		TreeNode n = new TreeNode(1);
		
		n.left = new TreeNode(2);
		n.left.right = new TreeNode(4);
		n.left.left = new TreeNode(3);
		n.right = new TreeNode(5);
		n.right.right = new TreeNode(6);
		n.right.left = new TreeNode(7);
		o.printWithIdention(n);
	}
}
