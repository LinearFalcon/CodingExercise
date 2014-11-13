package edu.nyu.liangfang.leetcode;

public class wildcardMatching {
	// AC solution - Greedy Algorithm
	public boolean isMatch(String s, String p) {
        int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {	// ignore normal match
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {	// if p's head is '*'
				star = j++;
				mark = i;
			} else if (star != -1) {		// if p's head is not '*' and also does not match s's current head, but we have previous star
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
    }
	
	
	// Correct but TLE solution
	public boolean isMatch_TLE(String s, String p) {
		
		if (p.length() == 0) {
            return s.length() == 0;
        }
        
        if (p.charAt(0) != '*') {
            if (s.length() < 1) {
                return false;
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') &&
                        isMatch(s.substring(1), p.substring(1));
            }
        } else {
            while (s.length() > 0) {	// check if p's leading "*" matches some leading substring of s
                if (isMatch(s, p.substring(1))) {
                    return true;
                }
                
                s = s.substring(1);
            }
        }
        return isMatch(s, p.substring(1));
    }
}
