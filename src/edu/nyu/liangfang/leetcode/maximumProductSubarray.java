package edu.nyu.liangfang.leetcode;

public class maximumProductSubarray {
    // O(n)
    public int maxProduct(int[] A) {
        int res = A[0];        // max subarray product
        int max = A[0];        // max product that ends at current index
        int min = A[0];     // min product that ends at current index

        for (int i = 1; i < A.length; i++) {
            // compute max and min subarray product that ends at this index
            int big = Math.max(max * A[i], min * A[i]);
            int small = Math.min(max * A[i], min * A[i]);

            // update max and min
            max = Math.max(A[i], big);    // could just be A[i] or product with previous num
            min = Math.min(A[i], small);

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
