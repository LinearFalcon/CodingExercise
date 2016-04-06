package edu.nyu.liangfang.leetcode;

public class constructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart > inend || poststart > postend)
            return null;

        int rootNum = postorder[postend];
        TreeNode root = new TreeNode(rootNum);

        int rootIndex = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == rootNum) {
                rootIndex = i;
                break;
            }
        }

        // rootIndex is not the length, so new postend should be equal to 'poststart + leftTreeLength - 1', leftTreeLength = rootIndex - (instart + 1)
        root.left = build(inorder, instart, rootIndex - 1, postorder, poststart, poststart + rootIndex - (instart + 1));
        // postend - 1 is because last element is root
        root.right = build(inorder, rootIndex + 1, inend, postorder, poststart + rootIndex - instart, postend - 1);
        return root;
    }
}
