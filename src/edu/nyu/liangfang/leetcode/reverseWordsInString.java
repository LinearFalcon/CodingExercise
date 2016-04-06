package edu.nyu.liangfang.leetcode;

public class reverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();

        int begin = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                if (begin == -1) begin = i;
            } else {
                if (begin != -1) {
                    sb.insert(0, s.substring(begin, i)).insert(0, " ");
                    begin = -1;
                }
            }
        }

        if (begin != -1)            // MUST check! If input is empty string, should not have sb.insert(...)!
            sb.insert(0, s.substring(begin));

        return sb.toString();
    }

    // short solution
    public String reverseWords_short(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] arr = s.split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
