package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class palindromePartitioning {
	// AC solution - just simple DFS
	public List<List<String>> partition(String s) {
	    List<List<String>> result = new LinkedList<List<String>>();
	    List<String> curr = new LinkedList<String>();
	    getPartition(s, result, curr);
	    return result;
	}
	
	public void getPartition(String s, List<List<String>> result, List<String> curr) {
	    if (s.length() == 0) {
	        result.add(curr);
	        return;
	    }            
	    
	    for (int i = 1; i <= s.length(); i++) {
	        String sub = s.substring(0, i);
	        List<String> tmp = new LinkedList<String>(curr);
	        if (isPalindrome(sub)) {
	            tmp.add(sub);
	            getPartition(s.substring(i), result, tmp);
	        } 
	    }
	}
	
	
	// TLE solution - Takes more time !!!
	public List<List<String>> partition_DP(String s) {
		List<List<String>> result = new LinkedList<List<String>>();
		if (s.length() == 0) {
			return result;
		}
		List<String> tmp = new LinkedList<String>();
		Hashtable<String, Boolean> palindromeTable = new Hashtable<String, Boolean>();  // store palindrome string already checked
		getPartitions(result, s, tmp, palindromeTable);
		return result;
	}

	private void getPartitions(List<List<String>> result, String remaining, List<String> tmp, Hashtable<String, Boolean> palindromeTable) {
		if (remaining.length() == 0) {
			result.add(tmp);
			return;
		}
		
		for (int i = 1; i <= remaining.length(); i++) {			// must start from 1 !
			LinkedList<String> clone = new LinkedList<String>(tmp);		// must not pass tmp itself, because it will be modified during recursion
			String partition = remaining.substring(0, i);
			if (palindromeTable.containsKey(partition)) {				// check if already checked this situation
				if (palindromeTable.get(partition)) {
					clone.add(partition); 
					getPartitions(result, remaining.substring(i), clone, palindromeTable);
				}
			} else {
				if (!isPalindrome(partition)) {
					palindromeTable.put(partition, false);
				} else {
					palindromeTable.put(partition, true);
					clone.add(partition);
					getPartitions(result, remaining.substring(i), clone, palindromeTable);
				}
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
