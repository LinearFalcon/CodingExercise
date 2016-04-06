package edu.nyu.liangfang.leetcode;

public class uniquePath2 {
    // O(n) space, one dimension DP array
    public int uniquePathsWithObstacles_lessSpace(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] pathNum = new int[n];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        pathNum[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    pathNum[j] = 0;
                } else if (j > 0) {
                    pathNum[j] = pathNum[j] + pathNum[j - 1];
                }
            }
        }
        return pathNum[n - 1];
    }

    // O(m*n) space iterative solution
    public int uniquePathsWithObstacles_iterative(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            map[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            map[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }

    // O(m*n) space + recursion solution
    public int uniquePathsWithObstacles_recursion(int[][] obstacleGrid) {
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
        if (obstacleGrid[row][col] == 1) {        // You should always first check the obstacle, if input [[1]], output should be 0
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
