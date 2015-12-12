package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length < 4) {
            return result;
        }
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {		
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int a = num[i];
                    int b = num[j];
                    int c = num[left];
                    int d = num[right];
                    int sum = a + b + c + d;
                    
                    if (sum == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(d);
                        result.add(list);
                        
                        do {
                            left++;
                        } while (left < right && num[left] == num[left - 1]);
                        
                        do {
                            right--;
                        } while (left < right && num[right] == num[right + 1]);
                        
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
