package edu.nyu.liangfang.leetcode;

public class searchInRotatedSortedArray {
	// assume no duplicate
	public int search(int[] A, int target) {
		int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {				// first check equals to A[mid]
                return mid;
            } else {
                if (A[mid] > A[low]) {			// check if A[low to mid] is in increasing order
                    if (target >= A[low] && target < A[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (A[mid] < A[low]) {	// check if A[mid to high] is in increasing order
                    if (target > A[mid] && target <= A[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {						// must deal with equals independently, if A[mid] == A[low], we can only search right part since no duplicate
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
        
}
