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
	// simple method
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<Character>();
        int start = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!set.contains(ch)) {
                set.add(ch);
            } else {				// find repeat, then shrink window
                max = Math.max(max, i - start);
                
                while (s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                /* set.remove(s.charAt(start)); */		// do not remove this!!! or you remove all occurrence of the repeated character, should keep one left 
                start++;
            }
        }
        max = Math.max(max, s.length() - start);	// last substring should also be checked
        return max;
    }
	
	
	
	// method 2
	public int lengthOfLongestSubstring_v2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        
        int p = 0; 
        int q = 1;
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        pos[s.charAt(0)] = 0;
        int max = Integer.MIN_VALUE;
        
        while (q < s.length()) {
            char qchar = s.charAt(q);
            if (pos[qchar] != -1) {
                max = Math.max(max, q - p);
                int repeatIndex = pos[qchar];
                for (int i = p; i <= repeatIndex; i++) {
                    pos[s.charAt(i)] = -1;
                }
                p = repeatIndex + 1;
            }
            
            pos[qchar] = q;
            q++;
        }
        max = Math.max(max, q - p);
        
        return max;
    }
	
	// algorithm is same as v2
	public int lengthOfLongestSubstring_v1(String s) {
		List<Character> subList = new ArrayList<Character>();
		int biggestLength = 0;

		int count = 0;
		for (int i = 0; i < s.length(); i++) {	
			char tmp = s.charAt(i);
			if (!subList.contains(tmp)) {
				count++;
				subList.add(tmp);
			} else {
				if (count > biggestLength) {
					biggestLength = count;
				}
				int index_of_repeat = subList.indexOf(tmp);
				count = count - index_of_repeat - 1;
				
				for (int j = 0; j <= index_of_repeat; j++ ) {
					subList.remove(0);
				}
				
				i--;
			}
		}
		
		// Consider the ending situation: longest substring is the last substring !!!!!!
		if (count > biggestLength) {
			biggestLength = count;
		}

		return biggestLength;
    }
}
