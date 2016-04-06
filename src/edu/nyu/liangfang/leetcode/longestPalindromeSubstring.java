package edu.nyu.liangfang.leetcode;

public class longestPalindromeSubstring {
    // My current version
    public String longestPalindrome1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String tmp1 = getPalin(s, i, i);
            String tmp2 = getPalin(s, i, i + 1);
            String longer = tmp1.length() > tmp2.length() ? tmp1 : tmp2;
            res = longer.length() > res.length() ? longer : res;
        }
        return res;
    }

    private String getPalin(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    /*
     *  isPalindrome[i][j]: whether substring start from i and end at j is palindrome
         isPalindrome[i][j] =  true if:
             s.charAt(i) == s.charAt(j) and ( isPalindrome[i+1][j-1] is true or j - i < 2)

         Complexity: O(n^2) time and O(n^2) space
     */
    public String longestPalindrome2(String s) {
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

    public String longestPalindrome_O1_Space(String s) {
        if (s.length() == 0) {
            return "";
        }

        String maxSub = "";
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i  -  odd number of chars
            String s1 = getLongestPalin(s, i, i);
            // get longest palindrome with center of i and i + 1  -  even number of chars
            String s2 = getLongestPalin(s, i, i + 1);

            String str = s1.length() > s2.length() ? s1 : s2;
            if (str.length() > maxSub.length()) {
                maxSub = str;
            }
        }
        return maxSub;
    }

    public String getLongestPalin(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
