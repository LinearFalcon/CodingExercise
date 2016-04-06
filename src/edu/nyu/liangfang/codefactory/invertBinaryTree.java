/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class invertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        root.left = invertTree(rightTree);
        root.right = invertTree(leftTree);
        return root;
    }
}