package edu.nyu.liangfang.leetcode;

public class maximumSubArray {
    //---------------- O(n) space, iterative version ------------------
    public int maxSubArray_iterative(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] maxSumEnd = new int[A.length];	// max sum of sub array ending at index i
        maxSumEnd[0] = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            maxSumEnd[i] = Math.max(A[i], A[i] + maxSumEnd[i - 1]);
            max = Math.max(max, maxSumEnd[i]);
        }
        return max;
    }
}	
