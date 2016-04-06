package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class threeSumCloset {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int minDist = Integer.MAX_VALUE;
        int closetSum = 0;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int a = num[i];
                int b = num[left];
                int c = num[right];
                int sum = a + b + c;
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }

                if (Math.abs(sum - target) < minDist) {
                    minDist = Math.abs(sum - target);
                    closetSum = sum;
                }
            }
        }
        return closetSum;
    }
}
