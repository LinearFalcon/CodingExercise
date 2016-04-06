package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 */

public class longgestSubstringWithoutRepeat {
    // latest version
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res = Math.max(res, i - left);
                while (s.charAt(left) != s.charAt(i)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(s.charAt(i));
            }
        }
        res = Math.max(res, s.length() - left);
        return res;
    }


    // v2 method
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<Character>();
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!set.contains(ch)) {
                set.add(ch);
            } else {                // find repeat, then shrink window
                max = Math.max(max, i - start);

                while (s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                /* set.remove(s.charAt(start)); */        // do not remove this!!! or you remove all occurrence of the repeated character, should keep one left
                start++;
            }
        }
        max = Math.max(max, s.length() - start);    // last substring should also be checked
        return max;
    }
}
