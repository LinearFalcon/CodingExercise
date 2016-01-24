package edu.nyu.liangfang.leetcode;


public class pow {

    // time O(lgn)  space O(1)
    public double powSol2(double x, int n) {
    	if (n < 0) {
    		return 1 / power(x, -n);
    	} else {
    		return power(x, n);
    	}
    }
    
    public double power(double x, int n) {
    	if (n == 0)
    		return 1;
     
    	double v = power(x, n / 2);
    	if (n % 2 == 0) {		
    		return v * v;
    	} else {
    		return v * v * x;
    	}
    }
     
}
