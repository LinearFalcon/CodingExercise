package edu.nyu.liangfang.leetcode;
import java.util.Stack;


public class InverseStringWithoutReverseWord {
	public void inverse(String str) {
		Stack<String> st = new Stack<String>();
//		StringBuffer s = new StringBuffer();
		boolean flag = false;
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if (!flag && ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'))) {
				flag = true;
			} else if (flag && !((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'))) {	// space or others
				flag = false;
			}
			
			if (flag) {
				s += str.charAt(i);
			} else {
				st.push(s);
				st.push(String.valueOf(str.charAt(i)));
				s = "";
			}
		}
		if (flag)
			st.push(s);
		
		while (!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}
	
	public void inverse2(String str) {
		Stack<String> st = new Stack<String>();
		for (String s : str.split(",")) {
			st.push(s);
		}
		
		while (!st.isEmpty()) {
			System.out.print(st.pop());
			System.out.print(" ");
		}
	}
}
