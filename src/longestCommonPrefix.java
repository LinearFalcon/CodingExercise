package edu.nyu.liangfang.leetcode;

public class longestCommonPrefix {
	public String fun(String[] strs) {
		int index = 0;					// initial position
		boolean endFlag = false;
		StringBuilder commonPrefix = new StringBuilder();

		if (strs.length > 1) {
			while (true) {  
				char firstChar = '\0';			// initial char for comparing
				for (int i = 0; i < strs.length; i++) {   
					if (index > strs[i].length() - 1) {			// if found any string whose length is not smaller than current index value, end the loop
						endFlag = true;
						break;
					}
					
					if (firstChar == '\0') {				// if this is the first iterate of for loop, edit the 'firstChar' value
						firstChar = strs[i].charAt(index);
					} else if (strs[i].charAt(index) != firstChar) {		// if found any mismatch, just end proceeding
						endFlag = true;
						break;
					}
				}

				if (endFlag) {
					break;
				}

				commonPrefix.append(firstChar);
				index++;
			}
		} else if (strs.length == 1) {
			commonPrefix = new StringBuilder(strs[0]);
		}

		return commonPrefix.toString();
	}
}
