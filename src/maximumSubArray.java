package edu.nyu.liangfang.leetcode;

public class maximumSubArray {
	
	// O(1) space, recursion version
	public int maxSubArray_recursion(int[] A) {
        int[] largestSum = {Integer.MIN_VALUE};
        
        compute(A, largestSum, 0);
        return largestSum[0];
    }
    
    private int compute(int[] A, int[] largestSum, int start) {
        if (start >= A.length)
            return 0;
        
        int sum1 = A[start];	// either max is it self or this element plus max value of rest elements
        int sum2 = A[start] + compute(A, largestSum, start + 1);
        int currentLargest = Math.max(sum1, sum2);
        largestSum[0] = Math.max(currentLargest, largestSum[0]);
        return currentLargest;
    }
    
    // O(n) space, iterative version
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
