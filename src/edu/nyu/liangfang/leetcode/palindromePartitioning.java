package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class palindromePartitioning {
	// AC solution - just simple DFS and backtracking
	public List<List<String>> partition(String s) {
        List<List<String>> rst = new LinkedList<List<String>>();
        List<String> tmp = new LinkedList<String>();
        
        generate(s, rst, tmp);
        return rst;
    }
    
    public void generate(String s, List<List<String>> rst, List<String> tmp) {
        if (s.length() == 0) {
            rst.add(new LinkedList<String>(tmp));
            return;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                tmp.add(sub);
                generate(s.substring(i), rst, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
	
    private boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;

		int first = 0;
		int second = s.length() - 1;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(first) != s.charAt(second)) {
				return false;
			}
			first++;
			second--;
		}
		return true;
	}
    
	// --------- TLE solution ---------
	public List<List<String>> partition_tle(String s) {
        List<List<String>> rst = new ArrayList<>();
        rst.add(new ArrayList<String>());
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalin(sub)) {
                for (List<String> list : partition(s.substring(i))) {
                    List<String> curr = new ArrayList<>();
                    curr.add(sub);
                    curr.addAll(list);
                    rst.add(curr);
                }
            }
        }
        return rst;
    }
    
    public boolean isPalin(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
