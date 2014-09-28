package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class nextPermutation {
	public void nextPermutation(int[] num) {
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
