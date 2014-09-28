package edu.nyu.liangfang.leetcode;

public class uniquePath {
	public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[101][101];
        return compute(m - 1, n - 1, pathNum);	// remember question is m*n grid, so pass m-1 and n-1
    }
    
    private int compute(int row, int col, int[][] pathNum) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (pathNum[row][col] != 0) {
            return pathNum[row][col];
        }
        
        pathNum[row][col] = compute(row - 1, col, pathNum) + compute(row, col - 1, pathNum);
        return pathNum[row][col];
    }
}
