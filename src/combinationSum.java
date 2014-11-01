package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class combinationSum {
	// v1: most simple method
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        Arrays.sort(candidates);
        findComb(candidates, target, result, curr, 0 ,0);
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
	
	
	// -------------- version 2 ----------------
	public List<List<Integer>> solution_v2(int[] candidates, int target) {  
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
	
	
	// ------------------ version 3 --------------------
	public List<List<Integer>> combinationSum_v3(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        Arrays.sort(candidates);
        find(candidates, target, result, curr, 0 ,0);
        return result;
    }
    
    public void find(int[] candidates, int target, List<List<Integer>> result, 
            List<Integer> curr, int index, int sum) {
        if (sum == target) {
                result.add(curr);
                return;
        } 
        if (index >= candidates.length) {		// avoid index out of bound
            return;
        }
        
        int num = candidates[index];
        int remain = target - sum;
        
        for (int i = 0; i <= remain / num; i++) {
            List<Integer> tmp = new LinkedList<Integer>(curr);
            for (int j = 0; j < i; j++) {
                tmp.add(num);
            }
            
            int newIndex = index + 1;
            int newSum = sum + i * num;
            if (newSum <= target) {
            	find(candidates, target, result, tmp, newIndex, newSum);
            }
        }
    }
}
