package edu.nyu.liangfang.leetcode;

public class minimumWindowSubstring {
	// my version
	public String minWindow_mine(String S, String T) {
        char[] srcTable = new char[256];
        char[] foundTable = new char[256];
        int foundNum = 0;
        int left = -1, right = -1, min = S.length() + 1;	// min初始化为S.length() + 1，不是S.length()，否则输入("a","a")就输出空
        
        for (int i = 0; i < T.length(); i++) {
            srcTable[T.charAt(i)]++;
        }
        
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (srcTable[ch] != -1) {
                foundTable[ch]++;
                if (foundTable[ch] <= srcTable[ch]) {
                    foundNum++;
                }
                
                while (foundNum == T.length()) {
                    char prev = S.charAt(start);
                    if (srcTable[prev] == -1) {
                        start++;
                    } else {
                        foundTable[prev]--;
                        if (foundTable[prev] >= srcTable[prev]) {
                            start++;
                        } else {
                            if (i - start + 1 < min) {
                                min = i - start + 1;
                                left = start;
                                right = i;
                            }
                            start++;
                            foundNum--;
                            break;
                        }
                    }
                }
                
            }
        }
        return left == -1 ? "" : S.substring(left, right + 1);
    }
	
	
	// Standard version
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
            char ch = S.charAt(i);
            
            if (srcTable[ch] != 0) {
                foundTable[ch]++;	
                if (foundTable[ch] <= srcTable[ch])	// ignore redundant char!!!!!!只记录有效found
                    foundNum++;
                // find the window that satisfied this condition,
                // next step is to shrink the window by moving start forward
                if (foundNum == T.length()) {
                    while (start < i) {					// remember here!!!!!!!!!!
                        char prev = S.charAt(start);
                        if (srcTable[prev] == 0) {
                            start++;
                        } else {
                            foundTable[prev]--;		// 只要不是0，就减少一个found然后跟srcTable[prev]比较
                            if (foundTable[prev] >= srcTable[prev]) { 
                                start++;
                            } else {    // 缩减到当start前进一位后substring[start, i]没有包含所有T中char
                                break;	// 此时start仍然为能使得substring[start, i]包含所有T中char的最大index
                            }
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
