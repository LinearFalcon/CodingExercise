package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;


public class permutations {
	// V1
	public List<List<Integer>> permute(int[] num) {
        return createPerm(num, num.length - 1);
    }
    
    public List<List<Integer>> createPerm(int[] num, int index) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (index < 0) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        List<List<Integer>> prev = createPerm(num, index - 1);
        int curr = num[index];
        for (List<Integer> subList : prev) {
            for (int i = 0; i <= subList.size(); i++) {
                List<Integer> tmp = new LinkedList<Integer>(subList);
                tmp.add(i, curr);
                result.add(tmp);
            }
        }
        return result;
    }
	
    // V2
	public List<List<Integer>> permute_v2(int[] num) {
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
