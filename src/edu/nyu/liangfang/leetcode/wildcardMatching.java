package edu.nyu.liangfang.leetcode;

public class wildcardMatching {
	// AC solution - Greedy Algorithm
	// 贪心的策略，能匹配就一直往后遍历，匹配不上了就看看前面有没有'*'来救救场，再从'*'后面接着试。
	// 因为*匹配any sequence of characters，所以我们只关心最后一个*
	public boolean isMatch(String s, String p) {
        int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {	// ignore normal match
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {	// if p's head is '*', assign star and mark
				star = j++;					// must increment j here, but not i, since we try to firstly ignore the star, if not work, then come back
				mark = i;
			} else if (star != -1) {		// if p's current char is not '*' and also does not match s's current char, we go back to previous star
				mark++;
				i = mark;					// 每次无法匹配且前面有星的时候，就用star从mark的地方匹配一个（所以先++mark），然后接着while loop
				j = star + 1;
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
