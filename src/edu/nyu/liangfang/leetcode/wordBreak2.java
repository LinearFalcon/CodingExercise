package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class wordBreak2 {
	// DP - Backtracking solution
	public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        return findList(s, dict);		// if we want to do more pruning, we can pass a Map<String, List<String>> map to function
    }									// to store intermediate result
    
    public List<String> findList(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if (s.length() == 0) {
            result.add("");
            return result;		
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            String sub = s.substring(i);
            if (dict.contains(sub)) {
                List<String> prev = findList(s.substring(0, i), dict);
                for (String preStr : prev) {
                	// if preStr.length() is 0, means we compute it by findList(s.substring(0,0), dict), so
                	// we need to make sure middle char will not be " ", or we will have string start with 
                	// an empty char like " a";
                    result.add(preStr + (preStr.length() == 0 ? "" : " ") + sub);	
                }
            }
        }
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
