package edu.nyu.liangfang.leetcode;

public class sqrt {
	 // Iterative method
    public int sqrt_iterative(int x) {
        if (x == 0) {
            return 0;
        }
        long start = 1;
        long end = x;
        while (start <= end) {		// must contain equals condition, or 2 will fail
            long mid = (start + end) / 2;
            long prod = mid * mid;
            if (prod == x) {
                return (int)mid;
            } else if (prod < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)end;	// Attention!!!!!!!!
    }
	
	
	
	// Recursion
	public int sqrt(int x) {
        if (x == 0)
            return 0;
        return (int)sqrt(x, 1, x);
    }
    
	// 必须用long，以防止给的x太大导致int溢出
    private long sqrt(long x, long start, long end) {
        if (end - start == 1) {	
            return start;
        } 
        
        long mid = (start + end) / 2;
        long prod = mid * mid;
        if (prod == x) {
            return mid;
        } else if (prod < x) {
            return sqrt(x, mid, end);
        } else {
            return sqrt(x, start, mid);
        }
    }
    
}
