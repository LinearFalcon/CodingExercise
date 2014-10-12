package edu.nyu.liangfang.leetcode;

public class maximumProductSubarray {
	// O(n)
	public int maxProduct(int[] A) {
        int res = A[0];
        int max = A[0];
        int min = A[0];
        
        for (int i = 1; i < A.length; i++) {
            // compute max and min subarray product that ends at this index
            int a = Math.max(max * A[i], min * A[i]);
            int b = Math.min(max * A[i], min * A[i]);
            
            // update max and min
            max = Math.max(A[i], a);    // could just be A[i] or product with previous num
            min = Math.min(A[i], b);
            
            res = Math.max(res, max);
        }
        return res;
    }
	
	// O(n^2)
	public int maxProduct_brutalforce(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int product = 1;
            for (int j = i; j < A.length; j++) {
                product = product * A[j];
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }
}
