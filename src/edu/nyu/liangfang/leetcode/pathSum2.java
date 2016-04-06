package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pathSum2 {
    // simple version
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        compute(rst, curr, root, sum);
        return rst;
    }

    public void compute(List<List<Integer>> rst, List<Integer> curr, TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                curr.add(root.val);
                rst.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }

        curr.add(root.val);
        compute(rst, curr, root.left, sum);
        compute(rst, curr, root.right, sum);
        curr.remove(curr.size() - 1);
    }


    // my version
    public List<List<Integer>> pathSum_me(TreeNode root, int sum) {
        List<List<Integer>> rst = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        compute(root, rst, curr, 0, sum);
        return rst;
    }

    private void compute(TreeNode node, List<List<Integer>> rst, List<Integer> curr, int currSum, int sum) {
        if (node == null) return;
        else if (node.left == null && node.right == null) {
            currSum += node.val;
            curr.add(node.val);
            if (currSum == sum) rst.add(new LinkedList<Integer>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        curr.add(node.val);
        compute(node.left, rst, curr, currSum + node.val, sum);
        compute(node.right, rst, curr, currSum + node.val, sum);
        curr.remove(curr.size() - 1);
    }
}
