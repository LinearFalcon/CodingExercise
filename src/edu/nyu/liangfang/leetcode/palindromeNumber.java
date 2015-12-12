package edu.nyu.liangfang.leetcode;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

public class palindromeNumber {
	// reverse number and compare
	public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        return x == reverse(x);
    }
    
    public int reverse(int x) {
        int rst = 0;
        while (x != 0) {
            rst = rst * 10 + x % 10;
            x = x / 10;
        }
        return rst;
    }
	
	public boolean isPalindrome_iterative(int x) {
        if (x < 0) 
            return false;
        int len = 1;
        while ((int)(x / Math.pow(10, len)) != 0) {
            len++;
        }
        int num = x;
        int powNum = len + 1;
        while (num > 0 && powNum > 0) {
            powNum -= 2;
            int right = num % 10;
            int left = (int)(num / Math.pow(10, powNum));
            if (left != right) {
                return false;
            }
            num = (num - (int)(left * Math.pow(10, powNum)) - right) / 10;
        }
        return true;
    }
}
