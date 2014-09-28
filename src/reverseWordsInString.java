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
}
