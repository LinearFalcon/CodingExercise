package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;


public class implementStrStr {
	// O(1) space solution
	public String strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return haystack;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i) && 
                    haystack.length() - i >= needle.length()) {
                boolean found = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                
                if (found) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
	
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
