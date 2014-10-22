package edu.nyu.liangfang.leetcode;

public class regularExpressionMatch {
	public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // length == 1 is the case that is easy to forget.
        // as p is subtracted 2 each time, so if original
        // p is odd, then finally it will face the length 1
        if (p.length() == 1) {
            return (s.length() == 1)
                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        // next char is not '*': must match current character
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch(s.substring(1), p.substring(1));
            }
        } else {
            // check if p[0-1] matches 0 or more leading characters of s
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            
            // if next char is * and s.charAt(0) != p.charAt(0) and p.charAt(0) != ‘.' or s is empty now
            return isMatch(s, p.substring(2));  
        }
	}
}
