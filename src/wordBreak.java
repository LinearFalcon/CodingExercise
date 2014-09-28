package edu.nyu.liangfang.leetcode;

import java.util.Hashtable;
import java.util.Set;

public class wordBreak {
	// Better solution - DP
	/*
	 * canBreak[x] means whether [0,x) substring can be segmented
	 * 
	 * canBreak[i] can be true if S[0,i) is in dict
	 * 					    or if canBreak[0, k) == true and S[k, i) is in dict, 0 <= k < i
	 * 
	 */
	public boolean wordBreak_Sol1(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];    
        canBreak[0] = true;                                 
        
        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                if (canBreak[k] && dict.contains(s.substring(k, i))) {	// when k = 0, means we check S[0, S.length()) (Entire string)
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
	
	
	// my TLE solution
	public boolean wordBreak_Sol2(String s, Set<String> dict) {
        Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
        return canBreak(s, dict, table);
    }
    
    private boolean canBreak(String s, Set<String> dict, Hashtable<String, Boolean> table) {
        if (dict.contains(s)) {
            return true;
        } else if (table.containsKey(s)) {
            return table.get(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (canBreak(s1, dict, table) && canBreak(s2, dict, table)) {
                table.put(s, true);
                return true;
            }
        }
        table.put(s, false);
        return false;
    }
}
