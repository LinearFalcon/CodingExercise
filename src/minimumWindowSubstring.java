package edu.nyu.liangfang.leetcode;

public class minimumWindowSubstring {
	public String minWindow(String S, String T) {
        int[] srcTable = new int[256];  // T中每个字母的个数
        int[] foundTable = new int[256];    // 当前找到的T中每个字母的个数
        int foundNum = 0;   // number of chars in T found
        
        int begin = -1;     // start point of min length string
        int end = S.length();   // end point of min length string
        int minLength = S.length() + 1;
        
        // initialize srcTable
        for (int j = 0; j < T.length(); j++) {
            srcTable[T.charAt(j)]++;
        }
        
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            char character = S.charAt(i);
            
            if (srcTable[character] != 0) {
                foundTable[character]++;
                if (foundTable[character] <= srcTable[character])
                    foundNum++;
                // find the window that satisfied this condition,
                // next step is to shrink the window by moving start forward
                if (foundNum == T.length()) {
                    while (start < i) {
                        char ch = S.charAt(start);
                        if (srcTable[ch] == 0 || (--foundTable[ch] >= srcTable[ch])) {
                            start++;
                        } else {
                            break;
                        }
                    }
                    
                    if (i - start + 1 < minLength) {
                        minLength = i - start + 1;
                        begin = start;
                        end = i;
                    }
                    
                    // after processing this window, move start one step forward,
                    // and begin searching for another window
                    foundNum--;
                    start++;
                }
            }
        }
        
        return begin == -1 ? "" : S.substring(begin, end + 1);
    }
}
