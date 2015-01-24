package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class minimumPathSum {
	// #3 one dimension DP array method - each time use one dimension array to indicate this row
	// Space: O(n)
	public int minPathSum3(int[][] grid) {
		if (grid.length == 0) 
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {   // 必须单独处理第一行，因为dp初始化都为0
            dp[j] = grid[0][j] + dp[j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        
        return dp[n - 1];
	}

	// #2 Dynamic Programming: further node sum depends on previous, so must initial first row and first column
	// Space: O(m*n)
	public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
         
        int[][] res = new int[row][col];
        // init
        res[0][0] = grid[0][0];
         
        // left
        for(int i = 1; i < row; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        // top
        for(int j = 1; j < col; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
         
        // rest elements
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
         
        return res[row - 1][col - 1];
    }
	
	// #1 use relax method of Dijkstra's Algorithm
	public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] minPathSum = new int[rowLen][colLen];
        
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                minPathSum[i][j] = Integer.MAX_VALUE;
            }
        }
        minPathSum[0][0] = grid[0][0];
        
         for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i < rowLen - 1) {
                    int tmp = minPathSum[i][j] + grid[i + 1][j];
                    if (tmp < minPathSum[i + 1][j])
                        minPathSum[i + 1][j] = tmp;
                }
                if (j < colLen - 1) {
                    int tmp = minPathSum[i][j] + grid[i][j + 1];
                    if (tmp < minPathSum[i][j + 1])
                        minPathSum[i][j + 1] = tmp;
                }
            }
        }
        return minPathSum[rowLen - 1][colLen - 1];
    }
	
	
}
