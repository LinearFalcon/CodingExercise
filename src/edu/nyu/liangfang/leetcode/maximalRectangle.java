package edu.nyu.liangfang.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class maximalRectangle {

    // use functions from question 'largest rectangle in histogram'
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        // 2 dimension DP array to store each row's histogram heights
        int[][] rectangle = new int[rowLen][colLen];

        // fill this 2 dimension DP array
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                // 0 line should be processed specifically
                if (i == 0) {
                    rectangle[i][j] = (matrix[i][j] == '0' ? 0 : 1);
                } else {
                    rectangle[i][j] = (matrix[i][j] == '0' ? 0 : 1 + rectangle[i - 1][j]);
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < rowLen; i++) {
            int max = largestRectangleArea(rectangle[i]);
            maxArea = Math.max(maxArea, max);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int[] newArr = new int[height.length + 1];
        newArr = Arrays.copyOf(height, height.length + 1);


        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        int max = 0;
        while (index < newArr.length) {
            if (stack.isEmpty() || newArr[index] >= newArr[stack.peek()]) {
                stack.push(index++);
            } else {
                int pos = stack.pop();

                max = Math.max(max, newArr[pos] * (stack.isEmpty() ? index : index - stack.peek() - 1));
            }
        }
        return max;
    }
}
