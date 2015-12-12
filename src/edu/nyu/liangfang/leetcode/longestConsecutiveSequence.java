package edu.nyu.liangfang.leetcode;
import java.util.HashSet;
import java.util.Set;


public class longestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
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
