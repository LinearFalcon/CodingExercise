package edu.nyu.liangfang.leetcode;

public class reverseString {
	// no extra space use method
	public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(i, j));
            }
        }
        return sb.toString();
    }
	
	
	// use of regex
	public String reverseWords_v2(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 1; i--) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}
