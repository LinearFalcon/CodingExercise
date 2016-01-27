package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    // v1
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // These two lines are used to trim, it can decrease time cose
            // if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        rst.add(list);
                        do { left++; } while (left < right && nums[left] == nums[left - 1]);
                        do { right--; } while (left < right && nums[right] == nums[right + 1]);
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return rst;
    }


    // v2
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new LinkedList<>();
        if (nums.length < 4) return rst;
        
        // Arrays.sort(nums);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!map.containsKey(nums[i] + nums[j])) 
                    map.put(nums[i] + nums[j], new ArrayList<List<Integer>>());
                map.get(nums[i] + nums[j]).add(new ArrayList<Integer>(Arrays.asList(i, j)));
            }
        }
        
        Set<List<Integer>> set = new HashSet<>();
        for (int key : map.keySet()) {
            if (key > target - key) continue;
            if (map.containsKey(target - key) ) {
                List<List<Integer>> l1 = map.get(key);
                List<List<Integer>> l2 = map.get(target - key);
                for (List<Integer> l : l1) {
                    for (List<Integer> m : l2) {
                        if (noDuplicate(l, m)) {
                            List<Integer> list = new ArrayList<>(l);
                            list.addAll(m);
                            Collections.sort(list);
                            set.add(list);          // set dedup seems not correct
                        }
                    }
                }
            }
        }
        
        for (List<Integer> l : set) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < 4; i++) tmp.add(nums[l.get(i)]);
            rst.add(tmp);
        }
        return rst;
    }
    
    private boolean noDuplicate(List<Integer> l1, List<Integer> l2) {
        Set<Integer> s = new HashSet<>();
        s.add(l1.get(0)); s.add(l1.get(1));
        return !s.contains(l2.get(0)) && !s.contains(l2.get(1));
    }
}
