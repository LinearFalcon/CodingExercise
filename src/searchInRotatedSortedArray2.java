package edu.nyu.liangfang.leetcode;

public class searchInRotatedSortedArray2 {
	// Worst case time: O(n)
	public boolean search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return true;
            } 
            // left half is in increasing order
            if (A[low] < A[mid]) {
                if (target >= A[low] && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (A[low] > A[mid]) {   // right half is in increasing order
                if (target <= A[high] && target > A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {    // cannot determine, just skip this element
                low++;
            }
                
        }
        return false;
    }
}
