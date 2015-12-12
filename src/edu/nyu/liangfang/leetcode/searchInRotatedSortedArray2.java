package edu.nyu.liangfang.leetcode;

public class searchInRotatedSortedArray2 {
	// Worst case time: O(n)
	public boolean search(int[] A, int target) {
		int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {				// first check equals to A[mid]
                return true;
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
                } else {			// cannot determine which way to search		
                    low++;
                }
            }
        }
        return false;
    }
}
