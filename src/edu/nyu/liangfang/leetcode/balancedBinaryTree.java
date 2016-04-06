public class balancedBinaryTree {

    // Top down - O(N^2) time  N is number of nodes, this algorithm has duplicated computation
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    // Bottom up DFS - O(N) time  No repeated computation 
    public boolean isBalanced_dfs(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int left = dfsHeight(root.left);
        if (left == -1) return -1;
        int right = dfsHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}