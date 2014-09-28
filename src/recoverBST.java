package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;


public class recoverBST {
	public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        BST2Arr(root, arr);
        TreeNode first = null; 
        TreeNode second = null;
        int count = 0;
        int firstIndex = 0;					
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i).val < arr.get(i - 1).val) {
                if (count == 0) {
                    first = arr.get(i - 1);
                    firstIndex = i - 1;
                    count++;
                }
                else {
                    second = arr.get(i);
                }
            }
        }
        // handle when adjacent nodes in the in-order traversal arraylist are swapped
        // because if so, second would be null after the for loop, so we need to fix it
        if (second == null)
            second = arr.get(firstIndex + 1);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void BST2Arr(TreeNode root, ArrayList<TreeNode> arr) {
        if (root == null)
            return;
        BST2Arr(root.left, arr);
        arr.add(root);
        BST2Arr(root.right, arr);
    }
    
    /*
     * Method 2: constant space solution
     */
    public void recoverTree2(TreeNode root) {
        
        TreeNode[] arr = new TreeNode[3];
        TreeNode[] previous = new TreeNode[1];
        inorderTraversal(root, previous, arr);

        if (arr[1] == null)
            arr[1] = arr[2];
        int tmp = arr[0].val;
        arr[0].val = arr[1].val;
        arr[1].val = tmp;
        
    }
    
    private void inorderTraversal(TreeNode root, TreeNode[] previous, TreeNode[] arr) {
        if (root == null)
            return;
        
        inorderTraversal(root.left, previous, arr);
        
        if (previous[0] == null) {  
            previous[0] = root;
        } else if (root.val < previous[0].val) {
            if (arr[0] == null) {
            	arr[0] = previous[0];
            	arr[2] = root;
            } else {
            	arr[1] = root;
            }
        }
        previous[0] = root;
        
        inorderTraversal(root.right, previous, arr);
    }
    
    public void test(TreeNode[] arr) {
    	TreeNode root = new TreeNode(100);
    	root.left = new TreeNode(1200);
    	arr[0] = root;
    }
}
