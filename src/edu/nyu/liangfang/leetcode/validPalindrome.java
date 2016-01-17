package edu.nyu.liangfang.leetcode;

public class validPalindrome {
    // v1
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        
        String str = sb.toString().toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // v2
	public boolean isPalindrome_v2(String s) {
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
