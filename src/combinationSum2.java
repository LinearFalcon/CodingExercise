package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Hashtable;

public class combinationSum2 {
	public List<List<Integer>> solution(int[] num, int target) {
        Arrays.sort(num);  								// needed?
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentList = new LinkedList<Integer>();
		int sum = 0;											// intermediate variable
		int iterateStart = 0;	// each time, only need to iterate from this position
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
