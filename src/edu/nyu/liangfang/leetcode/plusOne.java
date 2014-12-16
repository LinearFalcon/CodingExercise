package edu.nyu.liangfang.leetcode;

public class plusOne {
	public int[] plusOne1(int[] digits) {
	    if(digits == null || digits.length==0)
	        return digits;
	    int carry = 1;
	    for(int i=digits.length-1;i>=0;i--)
	    {
	        int digit = (digits[i]+carry)%10; 
	        carry = (digits[i]+carry)/10;
	        digits[i] = digit;
	        if(carry==0)
	            return digits;    
	    }
	    int [] res = new int[digits.length+1];    
	    res[0] = 1;			// if execute here, means the number is 999999..9, so we just need to put 1 at the head
	    return res;
	}
	
	
	
	 public int[] plusOne2(int[] digits) {
	        int last = digits.length - 1;
	        int carry = 0;
	        boolean allNine = true;
	        int index = -1;
	        for (int i = last; i >= 0; i--) {
	            if (digits[i] != 9) {
	                index = i;
	                allNine = false;
	                break;
	            }
	        }
	        
	        if (allNine) {
	            int[] res = new int[digits.length + 1];
	            res[0] = 1;
	            for (int i = 1; i <= digits.length; i++) {
	                res[i] = 0;
	            }
	            return res;
	        } else {
	            for (int i = digits.length - 1; i > index; i--) {
	                digits[i] = 0;
	            } 
	            digits[index]++;
	            return digits;
	        }
	    }
}
