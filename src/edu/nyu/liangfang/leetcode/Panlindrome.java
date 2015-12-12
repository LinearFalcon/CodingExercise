package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.Stack;

public class Panlindrome {
	public boolean isPalindrome(String s) {
		if (s.isEmpty()) 
            return true;
        s = s.toLowerCase();						// Ignoring case
		ArrayList<Character> arr = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {		// Take alphanumeric characters to arraylist
			char temp = s.charAt(i);
			if ((temp >= '0' && temp <= '9') || (temp >= 'a' && temp <= 'z'))
			arr.add(s.charAt(i));
		}
			
		if (arr.size() == 0) {
			return true;
		}
//		else if (arr.size() == 1)   when only 1 char, stack will be empty, also return true!
//			return true;
		
		int length = arr.size();
		int count;
		Stack<Character> stack = new Stack<Character>();
		for (count = 0; count < length/2; count++) {
			stack.push(arr.get(count));
		}
		count = length/2;
		if (length % 2 != 0)		// if lenght is prime, then length/2 point to the middle one now, need to increment
			count++;
		while(!stack.empty()) {
			char c = stack.pop();
			if (c != arr.get(count))
				return false;
			count++;
		}
		return true;
    }
}
