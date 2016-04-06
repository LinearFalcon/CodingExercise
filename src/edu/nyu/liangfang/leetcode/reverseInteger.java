package edu.nyu.liangfang.leetcode;

public class reverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0 ? true : false;
        if (x < 0) x = -x;

        long num = (long) x;        // Use long to avoid overflow
        long newNum = 0;
        while (num > 0) {
            newNum = newNum * 10 + num % 10;
            num /= 10;
        }
        if (newNum > (long) Integer.MAX_VALUE || -newNum < (long) Integer.MIN_VALUE) return 0;
        return (int) (isNegative ? -newNum : newNum);
    }
}
