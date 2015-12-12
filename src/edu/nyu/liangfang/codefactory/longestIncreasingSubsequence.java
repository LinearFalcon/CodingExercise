package edu.nyu.liangfang.codefactory;

/*
 * Given a sequence of distinct integers, your program must remove as few 
 * elements as possible in order for the elements which are not removed to 
 * appear in ascending order. Find the longest length of such subsequence
 * 
 * Example.
 * Given   1 2 3 8 10 5 6 7 12 9 11 4 0 
 * Remove        8 10       12      4 0 
 * Remain  1 2 3      5 6 7    9 11       (ascending)
 * length: 8
 *
 * Algorithm: DP
 * dp[i] represents the length of longest increasing sub-sequence which ends at A[i].
 * dp[i] = max{ A[k]+1, where 0<=k<i and A[i]>A[k]} 
 * finally, go through f[i] and find the max and the # of duplicates of max.
 */
public class longestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] A) {
		if (A.length == 0) return 0;
		
		int[] dp = new int[A.length];
		dp[0] = 1;
		int maxLen = 0;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}
	
	
	// test
	public static void main(String[] args) {
		longestIncreasingSubsequence o = new longestIncreasingSubsequence();
		int[] A = {1,2,3, 8, 10, 5, 6, 7, 12, 9, 11, 4, 0};
		System.out.println(o.longestIncreasingSubsequence(A));
	}
}
