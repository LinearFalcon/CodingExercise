package edu.nyu.liangfang.leetcode;

public class editDistance {
	public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // len1+1, len2+1, because finally return dp[len1][len2]
        // dp[i][j] means the edit distance between two strings with 
        // length i and j, i.e., word1[0,...,i-1] and word2[0,...,j-1].
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        // Initial condition:
        // dp[i][0] = i, dp[0][j] = j
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        
        // 2 nesting for loop to compute the 2-D dp array
        for (int i = 1; i <= len1; i++) {
            int c1 = word1.charAt(i - 1);   //because dp[i][j] means s1[0..i-1] to s2[0..j-1]
            for (int j = 1; j <= len2; j++) {
                int c2 = word2.charAt(j - 1);
                
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[len1][len2];
    }
	
	
	// 这样写会导致Time Limit Exceed，可能是recursion call本身也占用资源和时间，还是直接iterative比较高效
	public int minDistance_recursion(String word1, String word2) {
		int len1 = word1.length();
        int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
                
        return recursionFun(word1, word2, dp, len1, len2);
	}

	private int recursionFun(String word1, String word2, int[][] dp, int i,
			int j) {
		if (i == 0) {
			return j;
		} else if (j == 0) {
			return i;
		} else if (dp[i][j] != 0) {
			return dp[i][j];
		}
		
		int c1 = word1.charAt(i - 1);
		int c2 = word2.charAt(j - 1);
		if (c1 == c2) {
			return recursionFun(word1, word2, dp, i - 1, j - 1);
		} else {
			int insert = recursionFun(word1, word2, dp, i, j - 1) + 1;
            int delete = recursionFun(word1, word2, dp, i - 1, j) + 1;
            int replace = recursionFun(word1, word2, dp, i - 1, j - 1) + 1;
            return Math.min(insert, Math.min(replace, delete));
		}
	}
}
