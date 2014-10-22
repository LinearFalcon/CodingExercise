package edu.nyu.liangfang.leetcode;

public class uniquePath {
	// one dimension DP array, O(n) space
	public int uniquePaths_1dimensionDP(int m, int n) {
        int[] pathNum = new int[n];
        pathNum[0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {	// 因为第一列都是1，所以每次计算pathNum[j]的时候，pathNum[j]这时还等于上面那个cell的值
                pathNum[j] = pathNum[j] + pathNum[j - 1];
            }    
        }
        return pathNum[n - 1];
    }
	
	// iterative DP solution, O(m*n) space
	public int uniquePaths_iterative(int m, int n) {
        int[][] pathNum = new int[m][n];			// how many paths from (0, 0) to (i, j)
        pathNum[0][0] = 1;
        
        for (int i = 1; i < n; i++) {
            pathNum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            pathNum[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
            }
        }
        return pathNum[m - 1][n - 1];
    }
	
	// recursion DP solution
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
    
    
    // O(m*n) time method, but has repeated computation
    public int uniquePaths_TLE(int m, int n) {
        int[] pathNum = {0};
        findPathNum(m, n, 0, 0, pathNum);
        return pathNum[0];
    }
    
    public void findPathNum(int m, int n, int row, int col, int[] pathNum) {
        if (row >= m || col >= n) {
            return;
        }
        if (row == m - 1 && col == n - 1) {
            pathNum[0]++;
        }
        findPathNum(m, n, row + 1, col, pathNum);
        findPathNum(m, n, row, col + 1, pathNum);
    }
}
