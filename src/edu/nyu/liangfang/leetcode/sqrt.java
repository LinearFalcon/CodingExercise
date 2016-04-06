package edu.nyu.liangfang.leetcode;

public class sqrt {
    // Iterative method
    public int sqrt_iterative(int x) {
        if (x <= 1)
            return x;

        long start = 1;     // Use long!!!
        long end = x;
        while (end - start >= 2) {
            long half = (start + end) / 2;
            long prod = half * half;
            if (prod == x) return (int) half;
            else if (prod < x) start = half;
            else end = half;
        }
        return (int) start;     // before return, convert to int!!!
    }


    // Recursion
    public int mySqrt_rec(int x) {
        if (x <= 1)
            return x;
        return sqrt(1, x - 1, x);
    }

    // 必须用long，以防止给的x太大导致int溢出
    private int sqrt(long start, long end, long target) {
        if (end - start < 2)
            return (int) start;

        long half = (start + end) / 2;
        long prod = half * half;
        if (prod == target) {
            return (int) half;
        } else if (prod < target) {
            return sqrt(half, end, target);
        } else {
            return sqrt(start, half, target);
        }
    }

}
