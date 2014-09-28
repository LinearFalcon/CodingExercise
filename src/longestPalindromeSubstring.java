package edu.nyu.liangfang.leetcode;

public class longestPalindromeSubstring {
	/*
	 *  table[i][j]: whether substring start from i and end at j is palindrome
	 	1, table[i][j] = table[i+1][j-1] if s.charAt(i) == s.charAt(j)
	 	2, table[i][j] = 0 if s.charAt(i) != s.charAt(j)
	 	Complexity: O(n^2) time and O(n^2) space
	 */
	public String longestPalindrome1(String s) {
        if (s.length() <= 1)
            return s;

        int length = s.length();
        // table[i][j] == 1 means substring start from i and end at j is palindrome
        int[][] table = new int[length][length];
        int maxLen = 0;
        String longestStr = null;
        
        // all single char string is palindrome
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        
        // all string that is formed of consecutive 2 same chars is palindrome
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }
        maxLen = 2; // may not need since we can assume there must be a unique palindrome
        
        for (int strLen = 3; strLen <= length; strLen++) {
            // i is start position
            for (int i = 0; i <= length - strLen; i++) {
                int j = i + strLen - 1;     // j is end position
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && strLen > maxLen) {
                        maxLen = strLen;
                        longestStr = s.substring(i, j + 1);
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        
        return longestStr;
    }
	
	/*
	 Scan string just for one time, and each time compute longest string upon treating 
	 current char as middle of the palindrome (2 cases: one char middle or two char middle)
	 Complexity: O(n^2) time and O(1) space
	 */
	public String longestPalindrome2(String s) {
        if (s.length() <= 1)
            return s;

        int length = s.length();
        String longestStr = s.substring(0, 1);
        
        for (int i = 0; i < length; i++) {
            // get longest palindrome with center of i  -  odd number of chars
            String tmp1 = getLongestPalindrome(s, i, i);
            // get longest palindrome with center of i and i + 1  -  even number of chars
            String tmp2 = getLongestPalindrome(s, i, i + 1);
            
            if (tmp1.length() > longestStr.length()) {
                longestStr = tmp1;
            }
            if (tmp2.length() > longestStr.length()) {
                longestStr = tmp2;
            }
        }
        
        return longestStr;
    }
    
    private String getLongestPalindrome(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
