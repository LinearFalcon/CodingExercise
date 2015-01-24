package edu.nyu.liangfang.leetcode;

public class oneEditDistance {
	// better version
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() > t.length()) {
            return helper(t, s);
        }
        return helper(s, t);	// make sure length of first argument is less than or equal to second one's length
    }
    
    public boolean helper(String s, String t) {
        boolean oneDiff = false;
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                if (oneDiff) return false;
                oneDiff = true;
                if (s.length() < t.length()) --i;	// ignore this different char in t, next loop i will still be the same
            }
        }
        
        return oneDiff || s.length() < t.length();
    }
	
	
	// my version
	public boolean isOneEditDistance2(String s, String t) {
        int lenDiff = Math.abs(s.length() - t.length());
        if (lenDiff >= 2) {
            return false;
        } else if (lenDiff == 0) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;			// must have one different char
        } else {
            String longS = (s.length() > t.length()) ? s : t;
            String shortS = (s.length() > t.length()) ? t : s;
            
            if (longS.contains(shortS)) {	// different char is in the head or tail of long string
                return true;
            }
            int pos = -1;
            for (int i = 0; i < longS.length(); i++) {	// different char is among middle chars
                if (shortS.charAt(i) != longS.charAt(i)) {
                    pos = i;
                    break;
                }
            }
            String newS = longS.substring(0, pos) + longS.substring(pos + 1);
            return newS.equals(shortS);
        }
    }
}
