package edu.nyu.liangfang.leetcode;

import java.util.List;


public class triangle {
	// DP solution Bottom Up - O(n) time , n is number of nodes  O(N) space
	public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();  // same as triangle.get(lastrow).size()
        int[] minSum = new int[n];
        
        for (int k = 0; k < triangle.get(n - 1).size(); k++) {
            minSum[k] = triangle.get(n - 1).get(k);
        }
        
        for (int i = n - 2; i >=0; i--) {   // from last second row to top
            for (int j = 0; j <= i; j++) {  // check each node in this row
                minSum[j] = Math.min(minSum[j], minSum[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minSum[0];
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
    
    private int getMin(List<List<Integer>> triangle, int listNum, int nodeNum, int[][] minPathSum) {
        if (listNum >= triangle.size()) {		// Pay attention, must be >= not >, since you are using index
            return 0;
        } else if (minPathSum[listNum][nodeNum] != Integer.MAX_VALUE) {
        	return minPathSum[listNum][nodeNum];
        }
        
        int nodeValue = triangle.get(listNum).get(nodeNum);
        minPathSum[listNum][nodeNum] = nodeValue + Math.min(getMin(triangle, listNum + 1, nodeNum, minPathSum), 
        		getMin(triangle, listNum + 1, nodeNum + 1, minPathSum));
        return minPathSum[listNum][nodeNum];
    }
    
	
	// TLE DFS solution
	public int minimumTotal_sol2(List<List<Integer>> triangle) {
        int[] min = {Integer.MAX_VALUE};
        findMinPathSum(triangle, 0, 0, 0, min);
        return min[0];
    }
    
    private void findMinPathSum(List<List<Integer>> triangle, int prevIndex, int currSum, int level, int[] min) {
        if (level >= triangle.size()) {
            if (currSum < min[0]) {
                min[0] = currSum;
            }
            return;
        }
        
        if (level == 0) {
            findMinPathSum(triangle, 0, triangle.get(level).get(0), level + 1, min);
        } else {
            int currIndex = prevIndex;
            findMinPathSum(triangle, currIndex, currSum + triangle.get(level).get(currIndex), level + 1, min);
           
            currIndex = prevIndex + 1;
            findMinPathSum(triangle, currIndex, currSum + triangle.get(level).get(currIndex), level + 1, min);
        }
    }
}
