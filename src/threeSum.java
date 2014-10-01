package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class threeSum {
	
	// O(n^2) time complexity
	public ArrayList<ArrayList<Integer>> threeSumNoHash(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return result;	
		Arrays.sort(num);				// must sort first
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i -1])
				continue;
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int a = num[i];
				int b = num[left];
				int c = num[right];
				int sum = a + b +c;
				if (sum == 0) {
					ArrayList<Integer> set = new ArrayList<Integer>();
					set.add(a);
					set.add(b);
					set.add(c);

					result.add(set);

					do {
						left++;
					} while (left < right && num[left] == num[left - 1]);
					do {
						right--;
					} while (left < right && num[right] == num[right + 1]);
				} else if (sum > 0) {
					right = right - 1;
				} else {
					left = left + 1;
				}
			}
		}
		return result;
	}
}
