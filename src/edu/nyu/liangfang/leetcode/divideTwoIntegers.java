package edu.nyu.liangfang.leetcode;

public class divideTwoIntegers {

	/*
     * Shift can be used to solve this problem. We shift the divisor left until it just smaller
	 * than dividend but if we keep shifting one more bit, it’s larger than dividend. Then we can 
	 * add the shifted value to the result and subtract the shifted value from dividend. Keep doing 
	 * this until dividend is smaller than divisor. In fact, every integer can be represented by a 
	 * set of base 2 so that shifting can be used.
	   
	   One thing needs to be mentioned is that we need to convert the integer to long type. 
	   Otherwise the Math.abs() value of Integer.MIN_VALUE will be quite strange.
	 */

    public int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long ans = 0;

        while (a >= b) {
            int shift = 0;
            while ((b << shift) <= a) {
                shift++;
            }
            ans += (long) 1 << (shift - 1);    // MUST first cast 1 to long, or if input (Integer.MIN_VALUE, -1) will cause overflow,
            a = a - (b << (shift - 1));        // and ans will become negative
        }

        if (negative && -ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (!negative && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return negative ? -(int) ans : (int) ans;
    }


    // edge condition test
    public static void main(String[] args) {
        divideTwoIntegers o = new divideTwoIntegers();
        System.out.println(o.divide(Integer.MIN_VALUE, -1));
    }
}
