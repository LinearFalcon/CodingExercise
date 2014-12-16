package edu.nyu.liangfang.leetcode;
import java.util.Stack;


public class validParenthese {
	public boolean sol(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char top;
			if (st.empty()) {
				top = '\0';
			} else {
				top = st.peek();
			}
			
			char charToPush = s.charAt(i);
			if ((top == '{' && charToPush == '}') || (top == '(' && charToPush == ')') || (top == '[' && charToPush == ']')) {
				st.pop();
			} else {
				st.push(charToPush);
			}
		}

		if (st.empty()) {
			return true;
		} 
		return false;
	}
}
