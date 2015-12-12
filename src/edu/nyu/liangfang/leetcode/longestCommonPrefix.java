package edu.nyu.liangfang.leetcode;

public class longestCommonPrefix {
	// compact version
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        boolean flag = false;
        while (true) {
            char pre = '\0';
            for (String s : strs) {
                if ((index >= s.length()) || (pre != '\0' && s.charAt(index) != pre)) {
                    flag = true;
                    break;
                }
                pre = s.charAt(index);
            }
            
            if (flag) {
                break;
            }
            index++;
        }
        
        return strs[0].substring(0, index);
    }
	
	
	// version 2
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
