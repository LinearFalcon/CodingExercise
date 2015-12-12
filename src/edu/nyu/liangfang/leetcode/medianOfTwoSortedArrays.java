package edu.nyu.liangfang.leetcode;

public class medianOfTwoSortedArrays {
	// binary search solution O(lg(m+n))
	public double findMedianSortedArrays_solution2(int A[], int B[]) {
		int m = A.length;
	    int n = B.length;
	    int total = m + n;
	    if (total % 2 == 0) {     // even number
	        return (findIndexK(A, B, total / 2, 0, m - 1, 0, n - 1) + findIndexK(A, B, total / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
	    } else {                    // odd number
	        return findIndexK(A, B, total / 2, 0, m - 1, 0, n - 1);
	    }
	}
	    
	// k is index of the element - pass k means find (k + 1)th element
	private double findIndexK(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {	

		int aLen = aEnd - aStart + 1;
	   	int bLen = bEnd - bStart + 1;
	     
	   	// Handle special cases
	   	if (aLen == 0)
	   		return B[bStart + k];
	   	if (bLen == 0)
	   		return A[aStart + k];
	   	if (k == 0)
	   		return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	    
	   	int aMid = aLen * k / (aLen + bLen); // a's middle count
	   	int bMid = k - aMid - 1; // b's middle count	must minus 1
	    
	   	// make aMid and bMid to be array index
	   	aMid = aMid + aStart;
	   	bMid = bMid + bStart;
	    
	  	if (A[aMid] > B[bMid]) {
	   		// Discard first half of B and second half of A
	   		k = k - (bMid - bStart + 1);
	   		aEnd = aMid;
	   		bStart = bMid + 1;
	  	} else {
	   		// Discard first half of A and second half of B
	   		k = k - (aMid - aStart + 1);
	   		bEnd = bMid;
	   		aStart = aMid + 1;
	   	}
	    
	   	return findIndexK(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	// --------------------- O(m+n) Parse A and B from start at the same time to find median --------------------- 
	public double findMedianSortedArrays_solution1(int A[], int B[]) {
        int i = 0;
        int j = 0;
        int len = A.length + B.length;
        double prev = 0;
        double last = 0;
        
        if (len < 2) {
            if (A.length == 0 && B.length == 0) return 0;
            if (A.length == 1) return A[0];
            else return B[0];
        }
        
        while ((i + j) <= (len / 2)) {
            prev = last;
            if (i >= A.length) {
                last = B[j];
                j++;
            } else if (j >= B.length) {
                last = A[i];
                i++;
            } else if (A[i] < B[j]) {
                last = A[i];
                i++;
            } else {
                last = B[j];
                j++;
            }
        }
        if (len % 2 == 0) {
            return (prev + last) / 2;
        }
        return last;
    }
}
