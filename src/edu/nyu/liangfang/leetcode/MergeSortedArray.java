package edu.nyu.liangfang.leetcode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int point = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        while (b >= 0) {			// If B array's element has all been copied to A, then done!
        	if (a >= 0) {			// If A array's element has all been copied to later slot, then only consider B array
        		if (A[a] < B[b]) {
        			A[point] = B[b];
        			b--;
        		} else {
        			A[point] = A[a];
        			a--;
        		}
        	} else {
        		A[point] = B[b];
        		b--;
        	}
            point--;
        }
    }
}
