package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class subsets {
	// DP solution
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
            List<Integer> tmp = new LinkedList<Integer>(sublist);	// Must! Cannot modify sublist since you already add prev's all sublist into result
            tmp.add(S[n - 1]);
            result.add(tmp);
        }
        return result;
    }
    
    
    // version 2
    public List<List<Integer>> subsets_V2(int[] S) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        getSubsetsOfLength(S, S.length, result);
        return result;
    }
    
    public List<List<Integer>> getSubsetsOfLength(int[] S, int n, List<List<Integer>> result) {
        List<List<Integer>> currList = new LinkedList<List<Integer>>();
        if (n == 0) {
            currList.add(new LinkedList<Integer>());
            result.add(new LinkedList<Integer>());
            return currList;
        }
        
        List<List<Integer>> prev = getSubsetsOfLength(S, n - 1, result);
        for (List<Integer> list : prev) {
            for (int i = 0; i < S.length; i++) {
                int num = S[i];
                List<Integer> tmp = new LinkedList<Integer>(list);
                if (tmp.isEmpty() || num > tmp.get(tmp.size() - 1)) {
                    tmp.add(num);
                    currList.add(tmp);
                }
            }
        }
        
        result.addAll(currList);
        return currList;
    }
}
