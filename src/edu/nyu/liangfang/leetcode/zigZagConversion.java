package edu.nyu.liangfang.leetcode;


public class zigZagConversion {
    // current version
    public String convert(String s, int numRows) {
        StringBuilder[] map = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) map[i] = new StringBuilder();     // MUST initialize !!!
        
        int p = 0;
        while (p < s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (p >= s.length()) break;
                map[i].append(s.charAt(p));
                p++;
            }
            if (p == s.length()) break;
            for (int i = numRows - 2; i > 0; i--) {
                if (p >= s.length()) break;
                map[i].append(s.charAt(p));
                p++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : map) {
            res.append(sb);
        }
        return res.toString();
    }

	// most simple solution
	public String convert_v2(String s, int nRows) {
        if (nRows == 1 || nRows >= s.length()) {	// must consider nRows >= s.length() 
            return s;
        }
        
        StringBuilder[] arr = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++)	
        	arr[i] = new StringBuilder();

        
        for (int i = 0; i < s.length(); i++) {
            int pos = i % (2 * nRows - 2);		// vertical char
            if (pos >= nRows) {
                pos = 2 * nRows - 2 - pos;		// diagonal char
            }
            arr[pos].append(s.charAt(i));
        }
        
        String res = "";
        for (int i = 0; i < nRows; i++) {
            res += arr[i].toString();
        }
        return res;
    }
}
