package edu.nyu.liangfang.leetcode;

import java.util.List;


public class triangle {
	// DP solution Bottom Up - O(n) time, n is number of nodes; O(N) space, N is size of triangle
	public int minimumTotal(List<List<Integer>> triangle) {
        int[] min = new int[triangle.size() + 1];
        for (int r = triangle.size() - 1; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                min[c] = triangle.get(r).get(c) + Math.min(min[c], min[c + 1]);
            }
        }
        return min[0];
    }
	
	
	// DP solution Top Down - iterative
	public int minimumTotal_TopDown(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return (triangle.get(0)).get(0);		// Must deal with 1 level independently, since for loop starts from i = 1
        
        int[][] sum = new int[triangle.size()][triangle.size()];
        sum[0][0] = (triangle.get(0)).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    sum[i][j] = (triangle.get(i)).get(0) + sum[i - 1][0];
                } else if (j == i) {
                    sum[i][j] = (triangle.get(i)).get(j) + sum[i - 1][j - 1];
                } else {
                    sum[i][j] = (triangle.get(i)).get(j) + Math.min(sum[i - 1][j - 1], sum[i - 1][j]);
                }
                
                if (i == triangle.size() - 1) {			// find min in the last level - leaves
                    min = Math.min(min, sum[i][j]);
                }
            }
        }
        
        return min;
    }
	
	// DP solution Top Down - O(n) time , n is number of nodes  O(N^2) space  N is number of last row
	public int minimumTotal_sol1(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int maxlen = triangle.get(triangle.size() - 1).size();
        int[][] minPathSum = new int[maxlen][maxlen];
        for (int i = 0; i < maxlen; i++) {
        	for (int j = 0; j < maxlen; j++) {
            	minPathSum[i][j] = Integer.MAX_VALUE;
            }
        }
        return getMin(triangle, 0, 0, minPathSum);
    }
    
	// getMin return the min path sum from this point to the bottom
    private int getMin(List<List<Integer>> triangle, int rowIndex, int nodeIndex, int[][] minPathSum) {
        if (rowIndex >= triangle.size()) {		// Pay attention, must be >= not >, since you are using index
            return 0;
        } else if (minPathSum[rowIndex][nodeIndex] != Integer.MAX_VALUE) {
        	return minPathSum[rowIndex][nodeIndex];
        }
        
        int nodeValue = triangle.get(rowIndex).get(nodeIndex);
        minPathSum[rowIndex][nodeIndex] = nodeValue + Math.min(getMin(triangle, rowIndex + 1, nodeIndex, minPathSum), 
        		getMin(triangle, rowIndex + 1, nodeIndex + 1, minPathSum));
        return minPathSum[rowIndex][nodeIndex];
    }
    
	
	// -------------------------- TLE DFS solution --------------------------
	private int min = Integer.MAX_VALUE;
    public int minimumTotal_tle(List<List<Integer>> triangle) {
        compute(triangle, 0, 0, 0);
        return min;
    }
    
    private void compute(List<List<Integer>> triangle, int row, int col, int sum) {
        sum += triangle.get(row).get(col);
        
        if (row == triangle.size() - 1) min = Math.min(min, sum);
        else {
            compute(triangle, row + 1, col, sum);
            compute(triangle, row + 1, col + 1, sum);
        }
    }
}
