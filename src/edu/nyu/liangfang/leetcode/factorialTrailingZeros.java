package edu.nyu.liangfang.leetcode;

// Note that a trailing zero is produced by 2 * 5.
// This question basically is counting the number of factor 5 (because factor 2 is always sufficient).
public class factorialTrailingZeros {
	// O(lgN) method
	public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {			// if you want to run in log time, must have 'n /= 5'
            n /= 5;
            result += n;
        }
        return result;
    }
	
	// TLE method1 - faster
	public int trailingZeroes_TLE1(int n) {
        int result = 0;
        int divisor = 5;
        while (divisor <= n) {
            result += n / divisor;
            divisor *= 5;
        }
        return result;
    }
	
	// TLE method2
	public int trailingZeroes_TLE2(int n) {
        int count = 0;
        int num = 0;
        while (num <= n) {
            num += 5;
            count++;
        }
        return count > 0 ? count - 1 : 0;
    }
}
