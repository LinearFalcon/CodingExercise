package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class nextPermutation {
	// O(n) method, since the remaining subarray to right of index 'left' would be already decreasing order
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
                    right = j;              // that's bigger than num[left] would be the first bigger one
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
        int index1 = -1;	// first index from end to start that num[index1] < num[index1 + 1]
        int index2 = -1;	// index of minimum num after index1 that's bigger than num[index1]
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index1 = i;
                break;
            }
        }
        
        if (index1 != -1) {
            int minBig = Integer.MAX_VALUE;
            for (int i = index1 + 1; i < num.length; i++) {
                if (num[i] > num[index1] && num[i] < minBig) {
                    minBig = num[i];
                    index2 = i;
                }
            }
            // swap number at index1 and index2
            int tmp = num[index1];
            num[index1] = num[index2];
            num[index2] = tmp;
            // sort rest of numbers from index1 + 1 to end
            Arrays.sort(num, index1 + 1, num.length);
            
        } else {
            Arrays.sort(num);
        }
    }
}
