package edu.nyu.liangfang.leetcode;
import java.util.Stack;


public class longestValidParentheses {
	
	/*
	 * Keep a stack storing index of left parentheses
	 * Scan once, and each time update maxLength
	 * Complexity: O(n)
	 */
	public int longestValidParenthesesSol(String s) {
        if (s.length() <= 1)
            return 0;

        int maxLength = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    maxLength = stack.isEmpty() ? Math.max(maxLength, i - start + 1) : Math.max(maxLength, i - stack.peek());
                }
            }   
        }
        return maxLength;
    }
	
	
	// naive solution
	public int longestValidParenthesesSol1(String s) {
        if (s.length() <= 1)
            return 0;
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // compute max length of valid parenthese of string starting at index i
            if (s.charAt(i) == '(') {
                Stack<Character> st = new Stack<Character>();
                int count = 0;
                for (int j = i; j < s.length(); j++) {
                    count++;
                    char ch = s.charAt(j);
                    if (st.isEmpty()) {
                        st.push(ch);
                    } else if (st.peek() == '(' && ch == ')') {
                        st.pop();
                    } else {
                        st.push(ch);
                    }
                    
                    if (st.isEmpty()) {
                        if (count > max) {
                            max = count;
                        }
                    }
                }
            }
        }
        return max;
    }
	
	
}
