package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;


public class combinations {
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
