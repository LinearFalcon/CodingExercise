package edu.nyu.liangfang.leetcode;
import java.util.Queue;
import java.util.LinkedList;

public class atoi {
	public int atoi(String str) {
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
