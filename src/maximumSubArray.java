package edu.nyu.liangfang.leetcode;

public class maximumSubArray {
	public int maxSubArray(int[] A) {
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
}	
