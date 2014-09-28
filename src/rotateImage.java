package edu.nyu.liangfang.leetcode;

public class rotateImage {
	public void rotate(int[][] matrix) {
        int level = matrix.length / 2;
        int n = matrix.length;
        
        for (int i = 0; i < level; i++) {
            for (int j = i + 1; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
