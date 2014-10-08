package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;


public class palindromePartitioning2 {
	public int minCut(String s) {
		if (s.length() == 0)		// corner condition
			return 0;
		Hashtable<String, Integer> minCuts = new Hashtable<String, Integer>();
		computeMinCut(s, minCuts);
		return minCuts.get(s);
	}
	
	
	private void computeMinCut(String remaining, Hashtable<String, Integer> minCuts) {
//		if (minCuts.containsKey(remaining))			don't need, since only when remaining not contains in minCuts will computeMinCut be called
//			return;

		if (remaining.length() == 0) {
			minCuts.put(remaining, -1);		// should be -1 when empty string, because we compute cut number
			return;
		}

		for (int i = remaining.length(); i >= 1; i--) {				
			String partition = remaining.substring(0, i);   	
			String leftStr = remaining.substring(i);
			if (isPalindrome(partition)) {
				if (!minCuts.containsKey(leftStr)) {	// for each nodes after one cut, only call recursion function when don't know min cut num
					computeMinCut(leftStr, minCuts);	
				}
					
				// if new minCut number is smaller, then remove old minCut number first, then add new one
				if (!minCuts.containsKey(remaining)) {
					minCuts.put(remaining, minCuts.get(leftStr) + 1);
				} else if (minCuts.get(leftStr) + 1 < minCuts.get(remaining)) {
					minCuts.remove(remaining);
					minCuts.put(remaining, minCuts.get(leftStr) + 1);
				}
					
				if (minCuts.containsKey(remaining) && (minCuts.get(remaining) == 0 || minCuts.get(remaining) == 1))
					break;
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
}
