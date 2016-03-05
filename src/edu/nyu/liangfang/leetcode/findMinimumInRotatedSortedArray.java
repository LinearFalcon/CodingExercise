package edu.nyu.liangfang.leetcode;

public class findMinimumInRotatedSortedArray {
    // version 1
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[high];
    }

	// simple method 2
	public int findMin2(int[] num) {
        int low = 0;
        int high = num.length - 1;
        
        while (low < high && num[low] >= num[high]) {	// make sure at least two elements and subarray is rotated
            int mid = low + (high - low) / 2;
            if (num[mid] > num[high]) {			// if num[mid] > num[high], then num[low to mid] > high
                low = mid + 1;
            } else {							// if num[mid] <= num[high], then num[mid+1 to high] > num[mid]
                high = mid;
            }
        }
        return num[low];
    }
}
