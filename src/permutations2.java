package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class permutations2 {
	// DFS
	public List<List<Integer>> permuteUnique_1(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        Arrays.sort(num);   	// must sort array first
        getPerm(num, result, curr, visited);
        return result;
    }
    
    public void getPerm(int[] num, List<List<Integer>> result, List<Integer> curr, boolean[] visited) {
        if (curr.size() == num.length) {
            result.add(curr);
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            List<Integer> tmp = new LinkedList<Integer>(curr);
            // 只有当当前数字没有访问过且它的前一个数字不相同或者相同但是访问过了，才能添加这个数字
            if (visited[i] || (i > 0 && num[i] == num[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            tmp.add(num[i]);
            getPerm(num, result, tmp, visited);
            visited[i] = false;
        }
    }
	
    // AC method - DFS
	// Hashtable to store <number, appear times> pair, then just like construct
	// trees, each time pick a key to add to list until this branch finish, so we avoid duplicate and sort
	public List<List<Integer>> permuteUnique_2(int[] num) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            if (!table.containsKey(num[i])) {
                table.put(num[i], 1);
            } else {
                table.put(num[i], table.get(num[i]) + 1);
            }
        }
        
        getPerm(num, table, result, new LinkedList<Integer>());
        return result;
    }
    
    public void getPerm(int[] num, Hashtable<Integer, Integer> table, 
            List<List<Integer>> result, List<Integer> list) {
        
        if (table.isEmpty()) {
            result.add(list);
            return;
        }
        
        for (int key : table.keySet()) {
            List<Integer> cloneList = new LinkedList<Integer>(list);
            Hashtable<Integer, Integer> cloneTable = new Hashtable<Integer, Integer>(table);
            if (cloneTable.get(key) == 1) {
                cloneTable.remove(key);
            } else {
                cloneTable.put(key, cloneTable.get(key) - 1);
            }
            
            cloneList.add(key);
            getPerm(num, cloneTable, result, cloneList);
        }
    }
	
	
    
    // ---------------- TLE method -----------------
 	public List<List<Integer>> permuteUnique3(int[] num) {
         if (num.length == 0) {
             return new LinkedList<List<Integer>>();
         }
         Arrays.sort(num);
         return perm(num, num.length - 1);
     }
     
     public List<List<Integer>> perm(int[] num, int index) {
         List<List<Integer>> result = new LinkedList<List<Integer>>();
         if (index == -1) {
             result.add(new LinkedList<Integer>());
             return result;
         }
         
         List<List<Integer>> prev = perm(num, index - 1);
         for (List list : prev) {
             for (int i = 0; i <= list.size(); i++) {
                 List<Integer> tmp = new LinkedList<Integer>(list);
                 if (i == list.size() || tmp.get(i) != num[index]) {
                     tmp.add(i, num[index]);
                     result.add(tmp);
                 }
             }
         }
         return result;
     }	
}
