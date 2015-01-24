package edu.nyu.liangfang.leetcode;

public class decodeWays {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        if (s.charAt(0) == '0')
            return 0;
            
        int[] decodeWays = new int[s.length() + 1];
        
        decodeWays[0] = 1;
        decodeWays[1] = 1;
        
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                decodeWays[i] = decodeWays[i - 1];
            }
            
            int num = Integer.valueOf(s.substring(i - 2, i));
            if (num <= 26 && num >= 10) {
                decodeWays[i] += decodeWays[i - 2];
            }

        }
        return decodeWays[s.length()];
    }
}
