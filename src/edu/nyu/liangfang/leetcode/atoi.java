package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class atoi {
	// Better solution
	public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        String s = str.trim();
        boolean isPositive = true;
        double res = 0;			// use double to avoid overflow, in Leetcode, long will still cause overflow
        int i = 0;
        if (s.charAt(0) == '+') {
            i++;
        } else if (s.charAt(0) == '-') {
            isPositive = false;
            i++;
        }
        // '-0012a42' -> '-12'  only need to consider valid part of this string
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            res = res * 10 + s.charAt(i) - '0';			// do not use Math.pow(), not efficient!!! Use this way
            i++;
        }
        
        if (!isPositive) {
            res = -res;
        }
        
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)res;
        }
    }
	
	
	// 2nd time
	public int atoi_2nd(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        String s = str.trim();
        int n = s.length();
        boolean isPositive = true;
        long res = 0;
        int i;	
        for (i = 0; i < n; i++) {
            if (i == 0) {
                if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != '+' 
                        && s.charAt(i) != '-') {
                    break;            
                } else if (s.charAt(i) == '-') {
                    isPositive = false;
                } else if (s.charAt(i) == '+') {
                    isPositive = true;
                } else {
                    res += (s.charAt(i) - '0') * Math.pow(10, n - i - 1);
                }
            } else {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    break;
                } else {
                    res += (s.charAt(i) - '0') * Math.pow(10, n - i - 1);
                }
            }
        }
        
        if (!isPositive) {
            res = -res;
        }
        res /= Math.pow(10, n - i);		// '-0012a42' -> '-12', need to cut tailing 0 if loop end early
        
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)res;
        }
    }
	
	public int atoi_toomuchspace(String str) {
		boolean valid = false;
		boolean isNegative = false;
		int count = 0;
		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (!valid) {							// check first nonEmpty character
				if (str.charAt(i) == ' ') {
					continue;
				} else {
					char s = str.charAt(i);
					if (s != '+' && s != '-' && (s > '9' || s < '0')) {
						valid = false;
						break;
					}
						
					else if (s == '+' || s == '-') {
						valid = true;
						isNegative = (s == '-') ? true : false;
					} else {  		// (s >= '0' && s <= '9')
						valid = true;
						count++;
						Q.add(s - '0');
					}
				}
			} else {								// check following character
				char s = str.charAt(i);
				if (s < '0' || s > '9') {
					break;
				} else {
					count++;
					Q.add(s - '0');
				}
			}		
		}
		// Must use long !!!  *************
		long num = 0;		// Because if the correct value is out of the range of representable values,  
		if (!valid) {		// INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
			return 0;
		} else {
			while (!Q.isEmpty()) {
				int d = Q.poll();
				count --;
				num += d * Math.pow(10, count);
			}
			if (isNegative)
				num = -num;
		}
		if (num > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if (num < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)num;
	}
}
