package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class permutations2 {
	public List<List<Integer>> permuteUnique(int[] num) {
        Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
        // firstly initialize the hash table to find all keys
        for (int i : num) {
            if (table.containsKey(i)) {
                table.put(i, table.get(i) + 1);
            } else {
                table.put(i, 1);
            }
        }
    
        return getPerm(table);
    }
    
    private List<List<Integer>> getPerm(Hashtable<Integer,Integer> table) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (table.isEmpty()) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        for (int num : table.keySet()) {
            Hashtable<Integer,Integer> clone = new Hashtable<Integer,Integer>(table);    
            if (clone.get(num) > 1) {
                clone.put(num, clone.get(num) - 1);
            } else {
                clone.remove(num);
            }
            
            for (List<Integer> list : getPerm(clone)) {
                list.add(0, num);
                result.add(list);
            }
        }
        
        return result;
    }
}
