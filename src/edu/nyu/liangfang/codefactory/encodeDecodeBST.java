package edu.nyu.liangfang.codefactory;

/*
 * Because Binary Search Tree has order, so we can reconstruct BST using only
 * pre-order traverse array, all we need to do is check if this node is in 
 * valid range, so we need to pass min and max to reconstruct recursion method
 */
public class encodeDecodeBST {
	// encode in pre-order
	public String encode(Node root) {
		if (root == null) return "";
		
		StringBuilder sb = new StringBuilder();
		encodeHelper(root, sb);
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private void encodeHelper(Node root, StringBuilder sb) {
		if (root == null) return;
		
		sb.append(root.val).append("#");
		encodeHelper(root.left, sb);
		encodeHelper(root.right, sb);
	}
	
	
	// decode using BST rules
	public Node decode(String s) {
		String[] arr = s.split("#");
		int[] a = new int[arr.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(arr[i]);
		}
		
		int[] index = {0};	// 必须要传一个能够mutable的index进去，因为读输入数组，每次都要保证index[0]++之后会影响后面调用的method
		return decodeHelper(a, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
	}

	private Node decodeHelper(int[] a, int minValue, int maxValue, int[] index) {
		if (index[0] == a.length) return null;
		if (a[index[0]] <= minValue || a[index[0]] >= maxValue) {
			return null;
		}
		
		Node root = new Node(a[index[0]]);
		
		index[0]++;
		root.left = decodeHelper(a, minValue, root.val, index);		//当前读入的数，只可能属于left或者right其中一个
		root.right = decodeHelper(a, root.val, maxValue, index);
		return root;
	}
	
	
	
	// test
	public static void main(String[] args) {
		encodeDecodeBST o = new encodeDecodeBST();
		Node n = new Node(30);
		n.left = new Node(20);
		n.left.left = new Node(10);
		n.right = new Node(40);
		n.right.left = new Node(35);
		n.right.right = new Node(50);
		
		String s = o.encode(n);
		System.out.println(s);
		
		Node root = o.decode(s);
		System.out.println(root.left.val);
		System.out.println(root.left.left.val);
		System.out.println(root.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
	}
}
