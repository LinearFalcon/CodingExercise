package edu.nyu.liangfang.leetcode;
import java.util.Stack;


public class validParenthese {
	public boolean sol(String s) {
		Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                char c = st.peek();
                if ((c == '(' && s.charAt(i) == ')') || (c == '{' && s.charAt(i) == '}') || (c == '[' && s.charAt(i) == ']'))
                    st.pop();
                else
                    st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
	}
}
