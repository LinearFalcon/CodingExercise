package edu.nyu.liangfang.leetcode;

public class interleavingString {
	// 2 Dimension Dynamic Programming method !!!
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // must initialize dp[0][0], dp[i][0] and dp[0][j]
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
                           (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
	
	
	// TLE method
	public boolean isInterleave_TLE(String s1, String s2, String s3) {
		if (s1.length() == 0) 
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        if (s3.length() != s1.length() + s2.length())
            return false;
        
        boolean flag1 = false;
        boolean flag2 = false;
        if (s1.charAt(0) == s3.charAt(0)) {
            flag1 = isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        if (s2.charAt(0) == s3.charAt(0)) {
            flag2 = isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        
        return flag1 || flag2;
    }
}
