package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class scrambleString {
	public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        
        // each time before recursion call, firstly check
        // if these two strings can be from the same one, TLE without this check!
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        String sort1 = String.valueOf(ss1);
        String sort2 = String.valueOf(ss2);
        if (!sort1.equals(sort2)) {
            return false;
        }
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            
            // check forward order
            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
            
            // check reverse order
            s21 = s2.substring(s2.length() - i);    // check mirror partition
            s22 = s2.substring(0, s2.length() - i);
            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
        }
        return false;
    }
}
