package edu.nyu.liangfang.leetcode;

public class romanToInteger {
	public int romanToInt(String s) {
        int[] table = new int[256];
        table['I'] = 1;
        table['V'] = 5;
        table['X'] = 10;
        table['L'] = 50;
        table['C'] = 100;
        table['D'] = 500;
        table['M'] = 1000;
        
        int curr = 0;
        int prev = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            curr = table[s.charAt(i)];
            if (curr <= prev) {
                sum += curr;
            } else {
                sum -= prev;
                sum += curr - prev;
            }
            prev = curr;
        }
        return sum;
    }
}
