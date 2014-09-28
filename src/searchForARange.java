package edu.nyu.liangfang.leetcode;

public class searchForARange {
	public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        compute(A, 0, A.length - 1, target, result);
        return result;
    }
    
    private void compute(int[] A, int start, int end, int target, int[] result) {
        if (start > end) {
            return;
        }
        
        int mid = (start + end) / 2;
        if (A[mid] < target) {
            compute(A, mid + 1, end, target, result);
        } else if (A[mid] > target) {
            compute(A, start, mid - 1, target, result);
        } else {
            int i = mid;
            int j = mid;
            while (i >= start) {
                if (A[i] == target)
                    i--;
                else
                    break;
            }
            while (j <= end) {
                if (A[j] == target)
                    j++;
                else
                    break;
            }
            result[0] = i + 1;
            result[1] = j - 1;
            
            return;
        }
    }
}
