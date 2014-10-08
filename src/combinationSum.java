package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class combinationSum {
	public List<List<Integer>> solution(int[] candidates, int target) {  
		Arrays.sort(candidates);  								// sort candidates array first
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentList = new LinkedList<Integer>();
		int sum = 0;											// intermediate sum of chosen candidates number
		int iterateStart = 0;									// each time, only need to iterate from this position, for avoiding adding repeated list like {2,1} and {1,2}
		compute(result, currentList, candidates, sum, target, iterateStart);
		return result;
	}

	private void compute(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int sum, int target, int iterateStart) {
		for (int i = iterateStart; i < candidates.length; i++) {
			List<Integer> cloneList = new LinkedList<Integer>(currentList);
			cloneList.add(candidates[i]);
			if (sum + candidates[i] == target) {
				result.add(cloneList);
				return;
			} else if (sum + candidates[i] > target) {
				return;
			} else {
				compute(result, cloneList, candidates, sum + candidates[i], target, i);
			}
		}
	}
}
