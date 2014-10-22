package edu.nyu.liangfang.leetcode;

public class longestPalindromeSubstring {
	/*
	 *  isPalindrome[i][j]: whether substring start from i and end at j is palindrome
	 	isPalindrome[i][j] =  true if:
	 		s.charAt(i) == s.charAt(j) and ( isPalindrome[i+1][j-1] is true or j - i < 2) 
	 	
	 	Complexity: O(n^2) time and O(n^2) space
	 */
	public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = -1;
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        
        return s.substring(left, right + 1);
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
