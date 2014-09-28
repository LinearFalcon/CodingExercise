package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class subsets {
	public List<List<Integer>> subsetsSol(int[] S) {
        Arrays.sort(S);
        return getSubSets(S, 0);
    }
    
    private List<List<Integer>> getSubSets(int[]S, int start) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (start == S.length) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        List<List<Integer>> sub = getSubSets(S, start + 1);
        for (List<Integer> list : sub) {
            List<Integer> clone = new LinkedList<Integer>(list);
            result.add(list);
            clone.add(0, S[start]);
            result.add(clone);
        }
        return result;
    }
}
