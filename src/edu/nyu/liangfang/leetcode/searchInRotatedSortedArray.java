package edu.nyu.liangfang.leetcode;

public class searchInRotatedSortedArray {
    // assume no duplicate
    public int search(int[] A, int target) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > nums[high]) {
                if (target > nums[mid] || target < nums[low])   // combine two cases
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (target < nums[mid] || target > nums[high])  // combine two cases
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

}
