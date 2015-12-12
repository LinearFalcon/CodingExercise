package edu.nyu.liangfang.leetcode;

/*
 * CTCI Chap 11  11.6  all rows and columns of matrix is sorted in ascending order
 */
public class FindElementInSotedMatrix {
	public boolean findElement(int[][] matrix, int target) {
		int row = 0; 
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] > target)
				col--;
			else
				row++;
		}
		return false;
	}
}