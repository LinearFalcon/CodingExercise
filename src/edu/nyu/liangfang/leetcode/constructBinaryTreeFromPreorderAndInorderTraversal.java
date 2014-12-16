package edu.nyu.liangfang.leetcode;

public class constructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend || instart > inend)
            return null;
        
        int rootNum = preorder[prestart];
        TreeNode root = new TreeNode(rootNum);
        
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootNum) {
                rootIndex = i;
                break;
            }
        }
        
        // When compute start and end point of preorder array, you must use 'prestart + rootIndex - instart' rather
        // than 'index'
        root.left = build(preorder, prestart + 1, prestart + rootIndex - instart, inorder, instart, rootIndex - 1);
        root.right = build(preorder, prestart + rootIndex - instart + 1, preend, inorder, rootIndex + 1, inend);
        return root;
    }
}
