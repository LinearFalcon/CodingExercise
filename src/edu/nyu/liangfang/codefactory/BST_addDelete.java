package edu.nyu.liangfang.codefactory;

public class BST_addDelete {

	// insert new node into a BST
	public Node insertNode(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}
		
		if (value < root.val) {
			root.left = insertNode(root.left, value);
		} else if (value > root.val) {
			root.right = insertNode(root.right, value);
		} else {
			root.val = value;	// or can do nothing
		}
		return root;
	}
	
	
	// delete node in BST - important
	public Node deleteNode(Node root, int value) {
		if (root == null) return null;
		
		if (value < root.val) {
			root.left = deleteNode(root.left, value);	// deleteNode return the root of modified tree
		} else if (value > root.val) {
			root.right = deleteNode(root.right, value);
		} else {
			if (root.right == null) {	// node to delete does not have right tree, return its left tree
				return root.left;
			}
			if (root.left == null) {	// same here
				return root.right;
			}
			
			// node to delete has both left and right child
			Node old = root;
			root = min(old.right);	// reassign root to leftmost node of original root's right subtree
			root.right = deleteMin(old.right);	// delete leftmost node from the right subtree and put it to become new root
			root.left = old.left;
		}
		return root;
	}

	// return root of new tree that deletes the minimum/leftmost node
	private Node deleteMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		return node;
	}

	// find leftmost node
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return min(node.left);
		}
	}
}
