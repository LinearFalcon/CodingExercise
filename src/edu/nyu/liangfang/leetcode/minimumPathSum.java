package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class minimumPathSum {
    // TLE solution - simple recursion, TLE due to duplicated computations
    public int minPathSum_tle(int[][] grid) {
        return getMinPath_tle(grid, grid.length - 1, grid[0].length - 1);
    }
    private int getMinPath_tle(int[][] grid, int r, int c) {
        if (r < 0 || c < 0) return Integer.MAX_VALUE;
        else if (r == 0 && c == 0) return grid[0][0];
        
        return grid[r][c] + Math.min(getMinPath_tle(grid, r - 1, c), getMinPath_tle(grid, r, c - 1));
    }

    // #1 Dynamic Programming: further node sum depends on previous, so must initial first row and first column
    // Space: O(m*n)
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] mem = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) mem[0][0] = grid[0][0];
                else if (i == 0) mem[i][j] = grid[i][j] + mem[i][j - 1];
                else if (j == 0) mem[i][j] = grid[i][j] + mem[i - 1][j];
                else {
                    mem[i][j] = grid[i][j] + Math.min(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }
        return mem[m - 1][n - 1];
    }

	// #2 one dimension DP array method - each time use one dimension array to indicate this row
	// Space: O(n)
	public int minPathSum3(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int[] mem = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) mem[0] = grid[0][0];
                else if (i == 0) mem[j] = grid[0][j] + mem[j - 1];
                else if (j == 0) mem[0] += grid[i][0];
                else {
                    mem[j] = grid[i][j] + Math.min(mem[j], mem[j - 1]);
                }
            }
        }
        return mem[n - 1];
	}
}
