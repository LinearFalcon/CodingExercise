package edu.nyu.liangfang.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        
        // copy original array and pad one 0 at the end
        int[] newArr = new int[height.length + 1];
        newArr = Arrays.copyOf(height, height.length + 1); // last bit will be 0 (default)
        // st always keep index of histogram whose height is in increasing order
        Stack<Integer> st = new Stack<Integer>();
        int maxArea = 0;
        
        int index = 0;
        
        while (index < newArr.length) {
            if (st.isEmpty() || newArr[index] >= newArr[st.peek()]) {
                st.push(index);
                index++;
            } else {
                int pos = st.pop();
                int width = st.isEmpty() ? index : index - st.peek() - 1;
                maxArea = Math.max(maxArea, newArr[pos] * width);
            }
        }
        return maxArea;
    } 
}
