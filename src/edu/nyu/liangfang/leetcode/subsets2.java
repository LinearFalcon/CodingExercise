package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class subsets2 {
	// simple method - DFS
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        Arrays.sort(num);
        getSubsets(num, result, curr, 0);
        return result;
    }
    
    public void getSubsets(int[] num, List<List<Integer>> result, List<Integer> curr, int pos) {
        // add subset of this layer
        result.add(new LinkedList<Integer>(curr));
        
        for (int i = pos; i < num.length; i++) {
            if (i == pos || num[i] != num[i - 1]) {	 	// avoid duplicate
                curr.add(num[i]);
                getSubsets(num, result, curr, i + 1);
                curr.remove(curr.size() - 1);			// important
            }
        }
    }
	
	
    // method with hashmap
	public List<List<Integer>> subsetsWithDup_table(int[] num) {
        Arrays.sort(num);
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        ArrayList<Integer> keys = new ArrayList<Integer>();
        // count frequency of each number
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
                keys.add(num[i]);	// store keys in ascending order
            }
        }
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        getSubSets(keys, map, 0, new LinkedList<Integer>(), result);
        return result;
    }
    
    private void getSubSets(ArrayList<Integer> keys, Hashtable<Integer, Integer> map, int curr, List<Integer> temp, List<List<Integer>> result) {
        if (curr == keys.size()) {
            result.add(temp);
            return;
        }
        
        int key = keys.get(curr);
        for (int i = 0; i <= map.get(key); i++) {  // how many key appears in the temp list
        	List<Integer> clone = new LinkedList<Integer>(temp);
            for (int j = 0; j < i; j++) {
                clone.add(key);
            }
            getSubSets(keys, map, curr + 1, clone, result);
        }
    }
}
