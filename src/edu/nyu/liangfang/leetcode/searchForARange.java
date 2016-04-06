package edu.nyu.liangfang.leetcode;

public class searchForARange {
    // O(lgn) method - just found left and right boundary
    public int[] searchRange_boundary(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) return res;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int pos = (low + high) / 2;
            if (target <= nums[pos]) {
                high = pos - 1;
            } else {
                low = pos + 1;
            }
        }
        int start = low;

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int pos = (low + high) / 2;
            if (target >= nums[pos]) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        int end = high;

        if (start <= end) {     // Have to check first, because we might not find target in nums!
            res[0] = start;
            res[1] = end;
        }
        return res;
    }

    // O(lgn) method - too long
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if (A == null || A.length == 0) {
            return res;
        }

        int low = 0;
        int high = A.length - 1;
        int pos = 0;
        // find a target, do not care where it is
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else if (A[mid] > target) {
                high = mid - 1;
            } else {
                res[0] = mid;
                res[1] = mid;
                pos = mid;
                break;
            }
        }
        // if no such target
        if (res[0] == -1) {
            return res;
        }

        // find the right boundary
        low = pos;
        high = A.length - 1;
        while (low <= high) {       // to finally put high at right boundary, we need equals condition
            int mid2 = (low + high) / 2;
            if (A[mid2] == target) {
                low = mid2 + 1;
            } else {            // since it's only possible that A[mid2] >= target, because we initialize low as pos
                high = mid2 - 1;
            }
        }
        res[1] = high;

        // find the left boundary, same as right
        low = 0;
        high = pos;
        while (low <= high) {
            int mid3 = (low + high) / 2;
            if (A[mid3] == target) {
                high = mid3 - 1;
            } else {
                low = mid3 + 1;
            }
        }
        res[0] = low;

        return res;
    }


    // Actually it costs O(n) time because of a linear search after we find one target
    public int[] searchRange_On(int[] A, int target) {
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
