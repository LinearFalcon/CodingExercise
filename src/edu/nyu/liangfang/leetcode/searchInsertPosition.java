package edu.nyu.liangfang.leetcode;

public class searchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A.length == 0 || A[0] >= target)
            return 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (target > A[i] && target <= A[i + 1])	//compare target to adjacent two elements, so biggest i can only A.length - 2
                return i + 1;
        }
        return A.length;
    }
}
