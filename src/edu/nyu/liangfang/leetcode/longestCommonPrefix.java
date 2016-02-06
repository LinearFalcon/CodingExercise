package edu.nyu.liangfang.leetcode;

public class longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";			// MUST remember to test empty array input
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean isBreak = false;
        while (!isBreak) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= index || ( i > 0 && strs[i].charAt(index) != strs[i - 1].charAt(index))) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) sb.append(strs[0].charAt(index));
            index++;
        }
        return sb.toString();
    }
}
