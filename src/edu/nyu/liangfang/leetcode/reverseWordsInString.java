package edu.nyu.liangfang.leetcode;
import java.util.Stack;

public class reverseWordsInString {
	public String reverseWords(String s) {
        char start = ' ';
        char point = ' ';
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            point = s.charAt(i);
            if (start == ' ' || start == '\t') {
                if (point != ' ' && point != '\t') {
                    sb = new StringBuilder();
                    sb.append(point);
                    start = point;
                }
            } else {
                if (point == ' ' || point == '\t') {
                    stack.push(sb.toString());
                    start = ' ';
                } else {
                    sb.append(point);
                }
            }
        }
        if (start != ' ' && start != '\t') {
            stack.push(sb.toString());
        }
        
        StringBuilder result = new StringBuilder();
        boolean justBegin = true;
        while (!stack.empty()) {
        	if (!justBegin) {
        		result.append(' ');
        	} else {
        		justBegin = false;
        	}
            result.append(stack.pop());
        }
        return result.toString();
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
