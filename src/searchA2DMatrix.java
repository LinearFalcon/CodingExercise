package edu.nyu.liangfang.leetcode;

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
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        
        int low = 0;
        int high = m - 1;
        int row = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // because at the end must be low = high - 1, so we need to 
        // check which one become -1, then we choose another(which will be 0);
        // If neither is less than 0, then we choose high as row because matrix[high][0] <= target and matrix[low][0] > target
        if (low < 0) {				
            row = high;
        } else if (high < 0) {
            row = low;
        } else {
        	row = high;
        }
        
        low = 0;
        high = n - 1;	
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(row);
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
