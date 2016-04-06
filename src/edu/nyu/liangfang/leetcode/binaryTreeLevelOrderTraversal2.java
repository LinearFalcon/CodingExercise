/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class binaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(root, rst, 0);
        return rst;
    }

    private void dfs(TreeNode root, List<List<Integer>> rst, int level) {
        if (root == null) return;

        if (level == rst.size()) rst.add(0, new ArrayList<Integer>());
        rst.get(rst.size() - 1 - level).add(root.val);
        dfs(root.left, rst, level + 1);
        dfs(root.right, rst, level + 1);
    }
}