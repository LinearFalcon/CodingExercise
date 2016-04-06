package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

*/
// 题目给出的[lower, upper]就是数组里面所有数的range，所以肯定是包含里面所有已有数字的，所以lower <= A[first element], upper >= A[last elemnt]。

public class missingRanges {
    // Best solution
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> list = new LinkedList<String>();
        int prev = lower - 1;                            // 将lower减一，使得跟中间的间隔情况一样，就不用单独处理了
        for (int i = 0; i <= A.length; i++) {  // 这里要检查到A.length，考虑upper > A[last]的情况
            int curr = (i == A.length) ? upper + 1 : A[i];    // 同理，upper + 1，不需要单独处理
            if (curr - prev >= 2) {
                list.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }

        return list;
    }

    public String getRange(int left, int right) {
        return (left == right) ? String.valueOf(left) : left + "->" + right;
    }


    // ---------------------- my AC version ----------------------
    public List<String> findMissingRanges_complicated(int[] A, int lower, int upper) {
        List<String> list = new LinkedList<String>();
        if (lower > upper) return list;
        else if (A.length == 0) {
            int diff = upper - lower;
            if (diff == 0) list.add(String.valueOf(lower));
            else list.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            return list;
        }

        int index = 0;
        if (A[index] > lower) {
            int diff = A[index] - lower;
            if (diff == 1) {
                list.add(String.valueOf(lower));
            } else if (diff > 1) {
                list.add(String.valueOf(lower) + "->" + String.valueOf(A[index] - 1));
            }
        }

        while (index + 1 < A.length) {
            int diff = A[index + 1] - A[index];
            if (diff == 2) {
                list.add(String.valueOf(A[index] + 1));
            } else if (diff > 2) {
                list.add(String.valueOf(A[index] + 1) + "->" + String.valueOf(A[index + 1] - 1));
            }
            index++;
        }
        if (A[index] < upper) {
            int diff = upper - A[index];
            if (diff == 1) {
                list.add(String.valueOf(A[index] + 1));
            } else if (diff > 1) {
                list.add(String.valueOf(A[index] + 1) + "->" + String.valueOf(upper));
            }
        }

        return list;
    }
}
