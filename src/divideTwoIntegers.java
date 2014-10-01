package edu.nyu.liangfang.leetcode;

public class divideTwoIntegers {

	/*
	 * Shift can be used to solve this problem. We shift the divisor left until it just smaller 
	 * than dividend but if we keep shifting one more bit, it’s larger than dividend. Than we can 
	 * add the shifted value to the result and subtract the shifted value from dividend. Keep doing 
	 * this until dividend is smaller than divisor. In fact, every integer can be represented by a 
	 * set of base 2 so that shifting can be used.
	   
	   One thing needs to be mentioned is that we need to convert the integer to long type. 
	   Otherwise the Math.abs() value of Integer.MIN_VALUE will be quite strange.
	 */
	public int divide(int dividend, int divisor) {
        // must convert to long before take Math.abs to avoid overflow
        long p = Math.abs((long)dividend);  
        long q = Math.abs((long)divisor);
        
        int result = 0;
        while (p >= q) {
            int count = 0;
            while (p >= (q << count)) {
                count++;
            }
            p -= q << (count - 1);
            result += 1 << (count - 1);
        }
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            return -result;
        else
            return result;
    }

}
