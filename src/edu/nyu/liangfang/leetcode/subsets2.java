package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


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
        // add subset of this layer - 因为是要输出所有的subset，所以任何中间subset都首先加入到result里面
        result.add(new LinkedList<Integer>(curr));
        
        for (int i = pos; i < num.length; i++) {
            if (i == pos || num[i] != num[i - 1]) {	 	// sorted数组 + recursion里面的if判断保证了遍历所有可能且不重复
                curr.add(num[i]);
                getSubsets(num, result, curr, i + 1);
                curr.remove(curr.size() - 1);			// important
            }
        }
    }
	
	
    // method with hashmap
	public List<List<Integer>> subsetsWithDup_table(int[] num) {
        Arrays.sort(num);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> keys = new ArrayList<Integer>();				// MUST !!!
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
    
    private void getSubSets(List<Integer> keys, Map<Integer, Integer> map, int curr, List<Integer> temp, List<List<Integer>> result) {
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
