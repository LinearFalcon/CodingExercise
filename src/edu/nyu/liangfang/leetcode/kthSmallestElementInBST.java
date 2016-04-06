public class Solution {
    // first solution
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return result;
    }

    private void find(TreeNode root, int k) {
        if (root == null) return;
        find(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        find(root.right, k);
    }

    // What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently

}