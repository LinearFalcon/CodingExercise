package edu.nyu.liangfang.leetcode;

import java.util.Stack;

public class evaluateReversePolishNotation {
public int evalRPN(String[] tokens) {
        
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
