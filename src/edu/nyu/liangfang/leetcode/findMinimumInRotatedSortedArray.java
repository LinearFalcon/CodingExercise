package edu.nyu.liangfang.leetcode;

public class findMinimumInRotatedSortedArray {
	// simple method
	public int findMin(int[] num) {
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
	
	
	// my AC code
	public int findMin_me(int[] num) {
        return find(num, 0, num.length - 1);
    }
    
    public int find(int[] num, int start, int end) {
        int mid = (start + end) / 2;
        if (mid == start) {		// only 1 or 2 elements situation
            return Math.min(num[start], num[end]);
        }
        
        if (num[mid] > num[start]) {
            if (num[mid] < num[end]) {	// num[start, end] is sorted
                return num[start];
            } else {					// mid is on the first increasing part
                return find(num, mid + 1, end);
            }
        } else {						// mid is in the second increasing half, but we need to make sure if it is the minimum element
            if (num[mid - 1] < num[mid]) {
                return find(num, start, mid - 1);
            } else {
                return num[mid];
            }
        }
    }
}