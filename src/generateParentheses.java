package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class generateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<String>();
		String currentStr = "";							// initial empty string
		generate(result, n, n, currentStr);
		return result;
	}

	private void generate(List<String> list, int lParenNum, int rParenNum, String currentStr) {
		if ((lParenNum == 0 && rParenNum == 0)) {
			
			if (isValid(currentStr) && !list.contains(currentStr))
				list.add(currentStr);
			return;
		}
	
		if (lParenNum > 0)
			generate(list, lParenNum - 1, rParenNum, currentStr + '(');
		
		if (rParenNum > 0) 
			generate(list, lParenNum, rParenNum - 1, currentStr + ')');
	}

	// check if given parentheses string is valid - same solution as Question: Valid Parentheses
	private boolean isValid(String s) {
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
