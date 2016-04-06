package edu.nyu.liangfang.leetcode;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class combinationSum2 {
    // DFS + avoid adding same list
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> rst = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(num);
        generate(num, target, rst, tmp, 0, 0);
        return rst;
    }

    public void generate(int[] num, int target, List<List<Integer>> rst, List<Integer> tmp, int sum, int start) {
        if (sum == target) {
            rst.add(new LinkedList<Integer>(tmp));
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (i == start || num[i] != num[i - 1]) {        // similar to question subsets II;
                if (sum + num[i] > target) break;            // pruning unnecessary recursion call

                tmp.add(num[i]);                            // if num[i] == num[i - 1], we ignore it since this situation has been considered in previous recursion
                generate(num, target, rst, tmp, sum + num[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    // ------------ slow complicated method -------------
    public List<List<Integer>> solution(int[] num, int target) {
        Arrays.sort(num);                                // needed?
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> currentList = new LinkedList<Integer>();
        int sum = 0;                                            // intermediate variable
        int iterateStart = 0;    // each time, only need to iterate from this position
        compute(result, currentList, num, sum, target, iterateStart);
        return result;
    }

    private void compute(List<List<Integer>> result, List<Integer> currentList, int[] num, int sum, int target, int iterateStart) {
        for (int i = iterateStart; i < num.length; i++) {
            List<Integer> cloneList = new LinkedList<Integer>(currentList);
            cloneList.add(num[i]);
            if (sum + num[i] == target) {
                if (notAddedBefore(result, cloneList))
                    result.add(cloneList);
                return;
            } else if (sum + num[i] > target) {
                return;
            } else {
                compute(result, cloneList, num, sum + num[i], target, i + 1);
            }
        }
    }

    // Determine whether currentList exists in result list (order free)
    private boolean notAddedBefore(List<List<Integer>> result, List<Integer> currentList) {
        for (List<Integer> list : result) {
            Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
            for (int num : list) {
                if (!table.containsKey(num)) {
                    table.put(num, 1);
                } else {
                    table.put(num, table.get(num) + 1);
                }
            }
            for (int i : currentList) {
                if (table.containsKey(i)) {
                    table.put(i, table.get(i) - 1);
                }
            }
            boolean isDiff = false;
            for (int key : table.keySet()) {
                if (table.get(key) != 0) {
                    isDiff = true;
                    break;
                }
            }
            if (!isDiff) {
                return false;
            }

        }
        return true;
    }
}
