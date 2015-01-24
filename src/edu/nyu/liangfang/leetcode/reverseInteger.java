package edu.nyu.liangfang.leetcode;

public class reverseInteger {
	public int reverse(int x) {
		boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        
        long num = 0;		// use long here
        while (x > 0) {
            int mod = x % 10;
            x = x / 10;
            num = num * 10 + mod;
        }
        
        num = isNegative ? -num : num;
        if (num <= (long)Integer.MAX_VALUE && num >= (long)Integer.MIN_VALUE) {
            return (int)num;
        } else {
            return 0;
        }
    }
}
