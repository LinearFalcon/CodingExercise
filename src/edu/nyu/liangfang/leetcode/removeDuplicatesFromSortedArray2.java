package edu.nyu.liangfang.leetcode;

public class removeDuplicatesFromSortedArray2 {
    // simple version
    public int removeDuplicates(int[] nums) {
        int tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[i] != nums[tail - 2])     // HAS to be nums[tail - 2] not 'i - 2' !!!
                nums[tail++] = nums[i]; 
        }
        return tail;
    }

    // my version
	public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        
        int tail = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                for (int j = 0; j < Math.min(2, count); j++)    // 这里必须要是Math.min(2, count)
                    nums[tail++] = nums[i - 1];
                count = 1;
            }
        }
        if (count > 0) {
            for (int j = 0; j < Math.min(2, count); j++)        // 这里必须要是Math.min(2, count)
                nums[tail++] = nums[nums.length - 1];
        }
        
        return tail;
    }
}
