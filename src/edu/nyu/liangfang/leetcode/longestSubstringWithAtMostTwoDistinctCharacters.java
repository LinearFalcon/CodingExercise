package edu.nyu.liangfang.leetcode;

import java.util.Hashtable;

public class longestSubstringWithAtMostTwoDistinctCharacters {
    // My version: sliding window with Hashtable, two pointers and a count for unique characters
    // Maintain a uniqueNum, update maxLen each time; If uniqueNum is bigger than 2, then shrink window
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        int maxLen = 0;
        int start = 0;
        int uniqueNum = 0;    // number of distinct characters found currently

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!table.containsKey(ch)) {
                table.put(ch, 1);
                uniqueNum++;
            } else {
                table.put(ch, table.get(ch) + 1);
            }

            if (uniqueNum <= 2) {
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                while (uniqueNum > 2) {
                    char c = s.charAt(start);
                    if (table.get(c) == 1) {
                        table.remove(c);
                        uniqueNum--;
                    } else {
                        table.put(c, table.get(c) - 1);
                    }
                    start++;
                }
            }
        }

        return maxLen;
    }
}
