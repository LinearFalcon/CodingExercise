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
		 if (digits == null || digits.length == 0)
			 return null;

		 boolean notExceed = false;
		 int i = digits.length - 1;
		 while (i >= 0) {
			 if (digits[i] < 9) {
				 digits[i]++;
				 notExceed = true;
				 break;
			 }
			 digits[i] = 0;
			 i--;
		 }

		 if (!notExceed) {
			 if (i < 0) {
				 int[] newDigits = new int[digits.length + 1];
				 newDigits[0] = 1;
				 return newDigits;
			 } else {
				 digits[i]++;
			 }
		 }
		 return digits;
	    }
}
