package edu.nyu.liangfang.leetcode;

public class findMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
        return find(num, 0, num.length - 1);
    }
    
    public int find(int[] num, int start, int end) {
        int mid = (start + end) / 2;
        if (mid == start || mid == end) {		// only 1 or 2 elements situation
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
