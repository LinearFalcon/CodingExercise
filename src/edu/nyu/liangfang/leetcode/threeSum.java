package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
	// latest compact version
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int remaining = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == remaining) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    rst.add(list);
                    do { left++; } while (left < right && nums[left] == nums[left - 1]);
                    do { right--; } while (left < right && nums[right] == nums[right + 1]);
                } else if (nums[left] + nums[right] < remaining) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return rst;
    }
	
	// O(n^2) time complexity
	public List<List<Integer>> threeSumNoHash(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return result;	
		Arrays.sort(num);				// must sort first
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i -1])							// 必须比较!!!!!! ignore same number after compute once
				continue;
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int a = num[i];
				int b = num[left];
				int c = num[right];
				int sum = a + b +c;
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(a);
					list.add(b);
					list.add(c);

					result.add(list);

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
