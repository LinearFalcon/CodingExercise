package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class subsets {
    // DP solution - recursion - No duplicate
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return getSubsets(S, S.length);
    }

    // return subsets of array with first n element in array S
    public List<List<Integer>> getSubsets(int[] S, int n) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (n == 0) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        List<List<Integer>> prev = getSubsets(S, n - 1);
        result.addAll(prev);
        for (List<Integer> sublist : prev) {
            List<Integer> tmp = new LinkedList<Integer>(sublist);    // Must! Cannot modify sublist since you already add prev's all sublist into result
            tmp.add(S[n - 1]);
            result.add(tmp);
        }
        return result;
    }


    // iterative version - faster
    public List<List<Integer>> subsets_iterative(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        rst.add(new ArrayList<Integer>());          // add a empty set first !!!
        for (int i = 0; i < S.length; i++) {
            int resultSize = rst.size();
            for (int j = 0; j < resultSize; j++) {      // 只用clone上一次的排在rst前面的subset，然后加入S[i]变成新的subset
                List<Integer> clone = new ArrayList<Integer>(rst.get(j));
                clone.add(S[i]);
                rst.add(clone);
            }
        }

        return rst;
    }
}
