package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] num) {
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
