package edu.nyu.liangfang.codefactory;

/*
 * How many palindrome substring in one input string
 * e.g, "aba": 4   "abba": 6
 */
public class palindromeSubstringNumber {
	public int palinNum(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		
		int res = 0;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) &&
						(j - i < 2 || isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					res++;
				}
			}
		}
		return res;
	}
}
