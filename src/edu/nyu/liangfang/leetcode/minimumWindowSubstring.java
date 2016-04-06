package edu.nyu.liangfang.leetcode;

public class minimumWindowSubstring {
    // my version
    public String minWindow_mine(String S, String T) {
        char[] srcTable = new char[256];
        char[] foundTable = new char[256];
        int foundNum = 0;
        int left = -1, right = -1, min = S.length() + 1;    // min初始化为S.length() + 1，不是S.length()，否则输入("a","a")就输出空

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
//                            break;	// don't need
                        }
                    }
                }

            }
        }
        return left == -1 ? "" : S.substring(left, right + 1);
    }


    // recent version
    public String minWindow(String s, String t) {
        int[] src = new int[256];
        int[] found = new int[256];
        int foundNum = 0;
        int left = -1, right = -1, min = s.length() + 1;

        for (int i = 0; i < t.length(); i++) src[t.charAt(i)]++;

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (src[ch] != 0) {
                found[ch]++;
                if (found[ch] <= src[ch]) foundNum++;

                while (foundNum == t.length()) {
                    char startCh = s.charAt(start);
                    if (src[startCh] == 0) {
                        start++;
                    } else {
                        found[startCh]--;
                        if (found[startCh] < src[startCh]) {
                            if (i - start + 1 < min) {
                                min = i - start + 1;
                                left = start;
                                right = i;
                            }
                            start++;
                            foundNum--;
                        } else {
                            start++;
                        }
                    }
                }
            }
        }
        return left == -1 ? "" : s.substring(left, right + 1);
    }
}
