package edu.nyu.liangfang.leetcode;

import java.util.Stack;

public class evaluateReversePolishNotation {
	// simple version
	public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        String operators = "+-*/";
        for (String s : tokens) {
            if (!operators.contains(s)) {
                st.push(Integer.valueOf(s));
                continue;
            }
            
            int b = st.pop();
            int a = st.pop();
            if (s.equals("+")) {
                st.push(a + b);
            } else if (s.equals("-")) {
                st.push(a - b);
            } else if (s.equals("*")) {
                st.push(a * b);
            } else {
                st.push(a / b);
            }
        }
        
        return st.pop();
    }
	
	// original version
	public int evalRPN_long(String[] tokens) {
        
        Stack<String> st = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                String b = st.pop();
                String a = st.pop();
                int s = Integer.valueOf(a) + Integer.valueOf(b);
                st.push(String.valueOf(s));
            } else if (tokens[i].equals("-")) {
                String b = st.pop();
                String a = st.pop();
                int s = Integer.valueOf(a) - Integer.valueOf(b);
                st.push(String.valueOf(s));
            } else if (tokens[i].equals("*")) {
                String b = st.pop();
                String a = st.pop();
                int s = Integer.valueOf(a) * Integer.valueOf(b);
                st.push(String.valueOf(s));
            } else if (tokens[i].equals("/")) {
                String b = st.pop();
                String a = st.pop();
                int s = Integer.valueOf(a) / Integer.valueOf(b);
                st.push(String.valueOf(s));
            } else {
                st.push(tokens[i]);
            }
        }
        String re = st.pop();
        return Integer.valueOf(re);
    }
}
