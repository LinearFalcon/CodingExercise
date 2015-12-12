package edu.nyu.liangfang.leetcode;

public class distinctSubsequences {
	public int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        
        for (int i = 0; i <= S.length(); i++) {		// Must Initialize dp[i][0] !!!!!!
            dp[i][0] = 1;					// if T is empty, then for every S, there is exact 1 subsequences - empty
        }
        
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[S.length()][T.length()];
    }
}
