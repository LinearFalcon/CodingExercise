package edu.nyu.liangfang.leetcode;

public class trappingRainWater {
    // version 1
    public int trap(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            leftMax[i] = max;
        }
        max = 0;
        for (int j = A.length - 1; j >= 0; j--) {
            if (A[j] > max) {
                max = A[j];
            }
            rightMax[j] = max;
        }

        int vol = 0;
        for (int k = 0; k < A.length; k++) {
            vol += Math.min(leftMax[k], rightMax[k]) - A[k];
        }
        return vol;
    }

    // version 2
    public int trap_v2(int[] A) {
        if (A.length < 2) {
            return 0;
        }

        // max left value of current index
        int[] maxL = new int[A.length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            maxL[i] = max;
            if (max < A[i]) {
                max = A[i];
            }
        }

        // max right value of current index
        int[] maxR = new int[A.length];
        max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            maxR[i] = max;
            if (max < A[i]) {
                max = A[i];
            }
        }

        // compute volume of each index
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            int vol = Math.min(maxL[i], maxR[i]) - A[i];
            if (vol > 0) {
                total += vol;
            }
        }
        return total;
    }
}
