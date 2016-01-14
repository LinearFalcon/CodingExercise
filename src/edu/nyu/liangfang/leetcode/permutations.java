package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;


public class permutations {
	// V1 - backtracking
	public List<List<Integer>> permute(int[] nums) {
        return getPerm(nums, nums.length - 1);
    }
    
    private List<List<Integer>> getPerm(int[] nums, int end) {
        List<List<Integer>> result = new ArrayList();
        if (end < 0) {
            result.add(new ArrayList<Integer>());       // MUST add an empty list to result at this edge case!
            return result;
        }
        
        List<List<Integer>> prev = getPerm(nums, end - 1);
        for (List l : prev) {
            for (int i = 0; i <= l.size(); i++) {       // new number can be inserted to any position
                List<Integer> clone = new ArrayList(l);
                clone.add(i, nums[end]);
                result.add(clone);
            }
        }
        return result;
    }
	
    // V2
	public List<List<Integer>> permute_v2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> curr = new ArrayList();
        boolean[] isChosen = new boolean[nums.length];
        getPerm(res, curr, nums, isChosen);
        return res;
    }
    
    private void getPerm(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] isChosen) {
        if (curr.size() == nums.length) {
            res.add(curr);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!isChosen[i]) {
                List<Integer> newCurr = new ArrayList(curr);
                newCurr.add(nums[i]);
                isChosen[i] = true;
                getPerm(res, newCurr, nums, isChosen);
                isChosen[i] = false;                    // remember to reset isChosen array
            }
        } 
    }
}
