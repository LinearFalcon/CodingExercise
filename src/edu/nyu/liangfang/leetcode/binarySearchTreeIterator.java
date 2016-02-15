/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        addAllLeftChildren(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        addAllLeftChildren(node.right);
        return node.val;
    }
    
    private void addAllLeftChildren(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}