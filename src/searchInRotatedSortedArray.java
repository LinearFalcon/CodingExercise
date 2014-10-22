package edu.nyu.liangfang.leetcode;

public class searchInRotatedSortedArray {
	
	// assume no duplicate in array and A is sorted
	public int search(int[] A, int target) {
        
        return search(A, target, 0, A.length - 1);
    }
    
    private int search(int[] A, int target, int start, int end) {
        if (start > end)
            return -1;
        
        int mid = (start + end) / 2;
        int midVal = A[mid];
        if (midVal == target) {
            return mid;
        } else {
            if (A[start] <= midVal && A[end] >= midVal) {
                if (target < midVal)
                    return search(A, target, start, mid - 1);
                else
                    return search(A, target, mid + 1, end);
            } else if (A[start] > midVal) {
                if (target > midVal && target <= A[end])
                    return search(A, target, mid + 1, end);
                else
                    return search(A, target, start, mid - 1);
            } else if (A[end] < midVal) {
                if (target < midVal && target >= A[start])
                    return search(A, target, start, mid - 1);
                else
                    return search(A, target, mid + 1, end);
            }
        }
        return 0;
    }
    
    // version 2
    public int search_v2(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }
    
    public int search_v2(int[] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        if (A[mid] == target) {
            return mid;
        } else if (A[start] <= A[mid]) {			// must have equals to deal with {3, 1} situation
            if (target < A[mid] && target >= A[start]) {
                return search_v2(A, target, start, mid - 1);
            } else {
                return search_v2(A, target, mid + 1, end);
            }
        } else {
            if (target <= A[end] && target > A[mid]) {
                return search_v2(A, target, mid + 1, end);
            } else {
                return search_v2(A, target, start, mid - 1);
            }
        }
    }
}
