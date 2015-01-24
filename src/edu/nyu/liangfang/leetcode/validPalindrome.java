package edu.nyu.liangfang.leetcode;

public class validPalindrome {
	public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        
        int low = 0, high = s.length() - 1;
        while (low < high) {
            while (!Character.isLetterOrDigit(s.charAt(low)) && low < high) {
                low++;
            }
            
            while (!Character.isLetterOrDigit(s.charAt(high)) && low < high) {
                high--;
            }
            
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
	
}
