package edu.nyu.liangfang.leetcode;

public class uniquePath2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        
        int[][] pathNum = new int[101][101];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return compute(obstacleGrid, m - 1, n - 1, pathNum);
    }
    
    private int compute(int[][] obstacleGrid, int row, int col, int[][] pathNum) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        if (pathNum[row][col] != 0) {
            return pathNum[row][col];
        }
        
        pathNum[row][col] = compute(obstacleGrid, row - 1, col, pathNum) + compute(obstacleGrid, row, col - 1, pathNum);
        return pathNum[row][col];        
    }
}
