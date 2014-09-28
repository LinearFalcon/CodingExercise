package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;


public class permutations {
	public List<List<Integer>> permute(int[] num) {
        int[] isChosen = new int[num.length];
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        getPerm(num, result, isChosen, new LinkedList<Integer>());
        return result;
    }
    
    private void getPerm(int[] num, List<List<Integer>> result, int[] isChosen, List<Integer> currList) {
        if (currList.size() == num.length) {
            result.add(currList);
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (isChosen[i] == 0) {
                isChosen[i] = 1;
                currList.add(num[i]);
                List<Integer> clone = new LinkedList<Integer>(currList);
                getPerm(num, result, isChosen, clone);
                
                isChosen[i] = 0;
                currList.remove(currList.size() - 1);
            }
        }
    }
}
