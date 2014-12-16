package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;


public class combinations {
	// DFS method
    public List<List<Integer>> combine_DFS(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> currList = new LinkedList<Integer>();
        findComb(n, k, currList, result, 0);
        return result;
    } 
    
    public void findComb(int n, int k, List<Integer> currList, 
            List<List<Integer>> result, int level) {
        
        if (level == k) {
            result.add(currList);
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new LinkedList<Integer>(currList);
            if (tmp.isEmpty() || i > tmp.get(tmp.size() - 1)) {
                tmp.add(i);
                findComb(n, k, tmp, result, level + 1);
            }
        }
    }
    
	// --------------------- another one -------------------------
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (k > n || n < 1) {
            return result;
        }
        
        return fillList(k, 1, n);
    }
    
    private List<List<Integer>> fillList(int k, int start, int n) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (k <= 0) {
            list.add(new LinkedList<Integer>());
            return list;
        }
        
        for (int i = start; i <= n - k + 1; i++) {
            for (List<Integer> sub : fillList(k - 1, i + 1, n)) {
                sub.add(0, i);  // add to head
                list.add(sub);
            }
        }
        return list;
    }
}



