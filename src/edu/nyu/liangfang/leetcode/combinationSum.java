package edu.nyu.liangfang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class combinationSum {
    // latest version
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        compute(candidates, rst, curr, target, 0);
        return rst;
    }

    private void compute(int[] arr, List<List<Integer>> rst, List<Integer> curr, int target, int index) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (target < arr[i]) break;             // trim is important!
            curr.add(arr[i]);
            compute(arr, rst, curr, target - arr[i], i);
            curr.remove(curr.size() - 1);
        }
    }

    // v2
    public List<List<Integer>> combinationSum_v2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        Arrays.sort(candidates);
        findComb(candidates, target, result, curr, 0, 0);
        return result;
    }

    public void findComb(int[] candidates, int target, List<List<Integer>> result,
                         List<Integer> curr, int start, int sum) {

        if (sum == target) {
            result.add(curr);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            List<Integer> tmp = new LinkedList<Integer>(curr);
            tmp.add(candidates[i]);

            findComb(candidates, target, result, tmp, i, sum + candidates[i]);
        }
    }
}
