package edu.nyu.liangfang.leetcode;

public class oneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
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
            
            if (longS.contains(shortS)) {	// different char is in the head of tail of long string
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
