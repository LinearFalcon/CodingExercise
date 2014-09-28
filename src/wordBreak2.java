package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class wordBreak2 {
	// DP solution
	public List<String> wordBreak(String s, Set<String> dict) {
		// store all possible string combinations of substring [i, s.length-1]
        Hashtable<Integer, List<String>> table = new Hashtable<Integer, List<String>>();	
        return getList(s, dict, 0, table);
    }
	
	private List<String> getList(String s, Set<String> dict, int start, Hashtable<Integer, List<String>> table) {
		if (start >= s.length()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		} else if (table.containsKey(start)) {	// reduce repeated recursion
			return table.get(start);
		}
		
		List<String> result = new ArrayList<String>();
		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);		// substring [start, i)
			// from start to find a string that exited in dict
			if (dict.contains(sub)) {
				for (String possible : getList(s, dict, i, table)) {
					String newStr;
					// avoid redundant whitespace at the end of a string
					if (possible.equals("")) {
						newStr = sub + possible;
					} else {
						newStr = sub + " " + possible;
					}
					result.add(newStr);
					
				}
				
			}
		}
		
		table.put(start, result);
		return result;
	}
	
	
	
	// naive TLE solution
	public List<String> wordBreak_naive(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        breakWord(s, dict, result, 0, "");
        return result;
    }
    
    private void breakWord(String s, Set<String> dict, List<String> result, int start, String curr) {
        if (start >= s.length()) {
            result.add(curr.substring(1));
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (dict.contains(word)) {
            	breakWord(s, dict, result, i, curr + " " + word);       		
            } 
        }
    }
}
