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
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        return check(s1, s2, s3, 0, 0, 0);
    }
    
    public boolean check(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        
        if (i <= s1.length() && j <= s2.length() && k < s3.length()) {
            boolean flag = false;
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                flag = check(s1, s2, s3, i + 1, j, k + 1);
                if (flag) {
                    return true;
                }
            }
            
            if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                flag = check(s1, s2, s3, i, j + 1, k + 1);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
