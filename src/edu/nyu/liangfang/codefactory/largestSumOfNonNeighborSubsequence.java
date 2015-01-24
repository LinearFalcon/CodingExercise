package edu.nyu.liangfang.codefactory;

// 给一个数组，有正有负，找出biggest sum of subsequence，这些数字不能相邻
// 如果都是负数，就返回0表示选一个空序列
public class largestSumOfNonNeighborSubsequence {
	// DP: dp[i] means largest sum of subsequence in A[0 ~ i]
	public int largestSum(int[] A) {
		if (A.length == 0) return 0;
		else if (A.length == 1) return A[0] > 0 ? A[0] : 0;		// Take care of single element at first !!!
		
		// dp[i] means largest sum of subsequence in A[0 ~ i]
		int[] dp = new int[A.length];
		
		// initialize first couple of elements in dp array
		dp[0] = A[0] > 0 ? A[0] : 0;
		dp[1] = A[1] > A[0] ? A[1] : dp[0];						// Mind how to compute dp[1] !!! 
		
		for (int i = 2; i < A.length; i++) {
			if (A[i] > 0) {
				dp[i] = Math.max(A[i] + dp[i - 2], dp[i - 1]); 	// Mind here, you need to consider 2 possibilities: has A[i] or doesn't
			} else {
				dp[i] = dp[i - 1];
			}
		}
		
		return dp[A.length - 1];
	}
	
	
	// test
	public static void main(String[] args) {
		largestSumOfNonNeighborSubsequence o = new largestSumOfNonNeighborSubsequence();
		int[] A = {3, -1, 10, 4};
		int[] B = {1,2,3,2,3,2};
		int[] C = {2,2,2,2,2,2,2};
		System.out.println(o.largestSum(C));
	}
}
