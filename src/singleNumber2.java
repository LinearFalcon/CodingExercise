package edu.nyu.liangfang.leetcode;

public class singleNumber2 {
	
	/*
	 * To solve this problem using only constant space, you have to rethink 
	 * how the numbers are being represented in computers -- using bits.
	 * If you sum the ith bit of all numbers and mod 3, it must be either 0 
	 * or 1 due to the constraint of this problem where each number must appear 
	 * either three times or once. This will be the ith bit of that "single number".
	 * A straightforward implementation is to use an array of size 32 to keep 
	 * track of the total count of ith bit.
	 */
	public int singleNumber2(int[] A) {
        int[] count = new int[32];  // each int has 32 bits
        int result = 0;
        // count number of appearance of each bit in all numbers
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {   // check if this bit of number is 1
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);    // set this bit to 1 if it is 1
        }
        return result;
    }
}
