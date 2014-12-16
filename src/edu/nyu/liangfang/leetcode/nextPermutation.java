package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class nextPermutation {
	// O(n) method, since the remaining subarray to right of index 'left' would be already in decreasing order
	public void nextPermutation(int[] num) {
        if (num.length == 0) {
            return;
        }
        int left = -1;
        int right = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                left = i;
                break;
            }
        }
        
        if (left == -1) {
            reverse(num, 0, num.length - 1);
        } else {
            for (int j = num.length - 1; j > left; j--) {
                if (num[j] > num[left]) {   // since this subarray would already be in decreasing order, so minimum number
                    right = j;              // that's bigger than num[left] would be the first bigger one when scan from right
                    break;
                }
            }
            
            int tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            reverse(num, left + 1, num.length - 1);
        }
    }
    
    public void reverse(int[] num, int beg, int end) {
        while (beg < end) {
            int tmp = num[beg];
            num[beg] = num[end];
            num[end] = tmp;
            beg++;
            end--;
        }
    }
	
	// Time: O(nlgn) because of Array.sort() takes O(nlgn)
	public void nextPermutation_simple(int[] num) {
		if (num.length == 0) {
            return;
        }
        
        int left = -1;
        int right = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                left = i;
                break;
            }
        }
        
        if (left == -1) {
            Arrays.sort(num);
        } else {
            for (int j = num.length - 1; j > left; j--) {
                if (num[j] > num[left]) {
                    right = j;
                    break;
                }
            }
            
            int tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            Arrays.sort(num, left + 1, num.length);
        }
    }
}
