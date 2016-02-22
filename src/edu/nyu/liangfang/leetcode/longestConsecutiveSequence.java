package edu.nyu.liangfang.leetcode;
import java.util.HashSet;
import java.util.Set;


public class longestConsecutiveSequence {
    // my latest compact version
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        
        int max = 0;
        for (int n : nums) {
            if (set.contains(n)) {
                int left = n - 1, right = n + 1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                }
                if (right - left - 1 > max) max = right - left - 1;
            }
        }
        return max;
    }

	public int longestConsecutive_v2(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        int max = 1;
        
        for (int e : num) {
            int count = 1;
            int left = e - 1;
            int right = e + 1;
            
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
