package edu.nyu.liangfang.leetcode;

public class searchInRotatedSortedArray2 {
    // current version
    public boolean search_v2(int[] nums, int target) {
        if (nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > nums[low]) {               // you can either compare with low or high
                if (target < nums[low] || target > nums[mid]) low = mid + 1;
                else high = mid - 1;
            } else if (nums[mid] < nums[low]) {
                if (target > nums[high] || target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                low++;       // if compare with high, here high--
            }
        }
        return false;
    }


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
