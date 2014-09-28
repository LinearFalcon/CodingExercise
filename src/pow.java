package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;


public class pow {
	// time O(lgn)  space O(n)
	public double powSol1(double x, int n) {
        Hashtable<Integer, Double> table = new Hashtable<Integer, Double>();
        if (n >= 0)
            return getPow(x, n, table);
        else									// Must consider negative exponenet!
            return 1 / getPow(x, -n, table);
    }
    
    private double getPow(double x, int n, Hashtable<Integer, Double> table) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (table.containsKey(n)) {
            return table.get(n);
        }
        
        
        double result;
        if (n % 2 == 0) {
            result = getPow(x, n / 2, table) * getPow(x, n / 2, table);
        } else {
            result = getPow(x, n / 2, table) * getPow(x, n / 2 + 1, table);
        }
        
        table.put(n, result);
        return result;
    }
    
    
    // Solution 2 - time O(lgn)  space O(1)
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
