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
        
        int[] bitNum = new int[32];   // each int has 32 bits
        // count number of appearance of each bit in all numbers
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            for (int j = 0; j < 32; j++) {
                bitNum[j] += (num & 1);		// count number of 1 in this bit
                num = num >> 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= ((bitNum[i] % 3) << i);	// set this bit to 1 if the number of 1 in this bit is not multiply of 3
        }

        return res;
    }

    // simple solution
    public int singleNumber2_mine(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            if (sum % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
