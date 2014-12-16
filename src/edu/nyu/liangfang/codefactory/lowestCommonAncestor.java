package edu.nyu.liangfang.codefactory;


public class lowestCommonAncestor {
	public boolean cover(Node root, Node node) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		return cover(root.left, node) || cover(root.right, node);
	}
	
	public Node lca(Node root, Node n1, Node n2) {
		if (root == null || n1 == null || n2 == null)
			return null;
		if (root == n1 || root == n2) {
			return root;
		}
		
		boolean n1_on_left = cover(root.left, n1);
		boolean n2_on_left = cover(root.left, n2);
		
		if (n1_on_left != n2_on_left) {
			return root;
		}
		return n1_on_left ? lca(root.left, n1, n2) : lca(root.right, n1, n2);
	}
}
