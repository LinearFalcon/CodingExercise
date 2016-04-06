package edu.nyu.liangfang.leetcode;

public class twoSum {
    // O(n) time O(n) space
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }


}
