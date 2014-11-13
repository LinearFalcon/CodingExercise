package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;


public class palindromePartitioning2 {
	// Better solution
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
		    return 0;
		}
		
		int len = s.length();
		int[] minCutFrom = new int[len + 1];        // min cut number of substring [i, len] (including last dummy tail)
		boolean[][] matrix = new boolean[len][len]; // means whether substring [i,j] is palindrome
		
		// initialize minCutFrom as worst situation
		for (int i = 0; i <= len; i++) {
		    minCutFrom[i] = len - i;
		}
		
		// 针对substring [i, len]，计算当[i,j]是palindrome时的min cut
		for (int i = len - 1; i >= 0; i--) {
		    for (int j = i; j < len; j++) {
		        if (s.charAt(i) == s.charAt(j) && (j - i < 2 || matrix[i + 1][j - 1])) {
		            matrix[i][j] = true;
		            minCutFrom[i] = Math.min(minCutFrom[i], 1 + minCutFrom[j + 1]);	// Because we parse from end to head, so minCutFrom[j+1] must already be computed
		        }
		    }
		}
		return minCutFrom[0] - 1;
	}
	
	
	
	// ----------- space consume and slow ---------------
	public int minCut_v2(String s) {
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
