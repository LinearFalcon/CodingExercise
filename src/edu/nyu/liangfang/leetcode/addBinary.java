package edu.nyu.liangfang.leetcode;
import java.util.LinkedList;
import java.util.List;


public class addBinary {
	/*
	 * #2: 
	 */
	public String addBinaryFun2(String a, String b) {
	    int m = a.length();
	    int n = b.length();
	    int carry = 0;
	    String res = "";
	    // the final length of the result depends on the bigger length between a and b, 
	    // (also the value of carry, if carry = 1, add "1" at the head of result, otherwise)
	    int maxLen = Math.max(m, n);
	    for (int i = 0; i < maxLen; i++) {
	        // start from last char of a and b
	        // notice that left side is int and right side is char
	        // so we need to  minus the decimal value of '0'
	        int p = i < m ? a.charAt(m - 1 - i) - '0' : 0;
	        int q = i < n ? b.charAt(n - 1 - i) - '0' : 0;
	        int tmp = p + q + carry;
	        carry = tmp / 2;
	        res = tmp % 2 + res;
	    }
	    return (carry == 0) ? res : "1" + res;
	}
	
	
	
	
	/*
	 * #1: convert string to list, then add them and convert the sum back to string
	 * 
	 * Comments: too long and too complicated
	 */
	public String addBinaryFun(String a, String b) {
		List<Character> alist = convertToList(a);
		List<Character> blist = convertToList(b);
		List<String> result = addTwoList(alist, blist);
		return listToString(result);
	}

	// reverse list
	private List<Character> convertToList(String s) {
		List<Character> list = new LinkedList<Character>();
		for (int i = s.length() - 1; i >= 0; i--) {
			list.add(s.charAt(i));
		}
		return list;
	}

	private List<String> addTwoList(List<Character> alist, List<Character> blist) {
		int carry = 0;
		int pointer = 0;
		List<String> result = new LinkedList<String>();
		while (!(carry == 0 && pointer >= alist.size() && pointer >= blist.size())) {
			int sum = 0;
			if (pointer < alist.size() && pointer < blist.size()) {
				sum += alist.get(pointer) - '0' + blist.get(pointer) - '0' + carry;
			} else if (pointer < alist.size()) {
				sum += alist.get(pointer) - '0' + carry;
			} else if (pointer < blist.size()) {
				sum += blist.get(pointer) - '0' + carry;
			} else {
				sum += carry;
			}
			carry = 0;
			pointer++;

			if (sum >= 2) {
				sum -= 2;
				carry = 1;
			}
			result.add(String.valueOf(sum));
		}
		return result;
	}
	
	// convert back to correct order
	private String listToString(List<String> list) {
		String result = "";
		for (String s : list) {
			result = s + result;
		}
		return result;
	}
	
	
}
