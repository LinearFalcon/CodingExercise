package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;

/*

Have you considered these scenarios?

1, needle or haystack is empty. If needle is empty, always return 0. If haystack is empty, then there will always be no match (return –1) 
   unless needle is also empty which 0 is returned.
2, needle’s length is greater than haystack’s length. Should always return –1. 
3, needle is located at the end of haystack. For example, “aaaba” and “ba”. Catch possible off-by-one errors.
4, needle occur multiple times in haystack. For example, “mississippi” and “issi”. It should return index 2 as the first match of “issi”.
 
*/

public class strStr {
	// Best clean solution
	public int strStr_clean(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
	
	// O(1) space solution
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                boolean found = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }
	
	// too complicated!
	public String strStr_linkedlist(String haystack, String needle) {
		LinkedList<Integer> positions = new LinkedList<Integer>();

		if (needle.length() == 0) {
			return haystack;
		}

		// get all possible starting positions from haystack
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0))
				positions.add(i);
		}

		int len = needle.length();
		for (int j : positions) {
			if (haystack.length() - j >= len) {				// Must consider: if the remaining substring is shorter than needle
				boolean isFound = true;
				for (int l = 0; l < len; l++) {
					if (haystack.charAt(j + l) != needle.charAt(l)) {
						isFound = false;
						break;
					}
				}
				if (isFound) {
					return haystack.substring(j);
				}
			}
		}
		return null;
	}
}
