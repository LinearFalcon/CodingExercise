package edu.nyu.liangfang.leetcode;

/*

This matrix has the following properties:
1, Integers in each row are sorted from left to right.
2, The first integer of each row is greater than the last integer of the previous row !!! (Attention)

*/
public class searchA2DMatrix {
	// method 1: treat as a sorted one dimension array, time: O(lg(m*n))
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
	
	// method 2: search for row then for column, time: O(lg(m*n)) = O(lg(m)) + O(lg(n))
	public boolean searchMatrix_rowcol(int[][] matrix, int target) {
		if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        int row = high;		// if cannot find, then high must be the index of num that's less than target
        if (row < 0) {		// however if matrix[0][0] is also bigger than target, high would be -1, 
            return false;	// so in this case just return false;
        }
        
        low = 0; 
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
