package edu.nyu.liangfang.leetcode;

public class containerWithMostWater {
	/*
	 * 
	 * [Thoughts]
		For any container, its volume depends on the shortest board.
		Two-pointer scan. And always move with shorter board index.
		
	   The volume = (j - i) * min(ai, aj)
	   if ai < aj, we should move i++, because if we make j--, the min(ai, aj) will always be less than or 
	   equal to ai, and (j - i) gets smaller, so the maximum area that can benefit from i is already recorded
	 */
	
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
        int prod = 0;
        while (left < right) {
            prod = Math.max(prod, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return prod;
    }
}
