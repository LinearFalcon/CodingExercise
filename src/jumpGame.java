package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class jumpGame {
	// O(n) solution, just scan from head and judge if we can jump to 
	// index (>= A.length-1) from currently 'can reach' index 
	public boolean canJump(int[] A) {
        int point = 0;			// current farthest index we can reach
        for (int i = 0; i < A.length; i++) {
            if (i <= point) {			
                if (point < A[i] + i) {
                    point = A[i] + i;
                }
                if (point >= A.length - 1) {
                    return true;
                }
                
            } else {	// if already scan to the index beyond reach, then return false
                return false;
            }
        }
        return false;
    }
	
	
	// DFS - faster than BFS, but still TLE
	public boolean canJump_DFS(int[] A) {
        
        return jumpCheck(A, 0);
    }
    
    private boolean jumpCheck(int[] A, int index) {
        if (index >= A.length - 1) {
            return true;
        }
        
        for (int i = 1; i <= A[index]; i++) {
            if(jumpCheck(A, index + i)) {
            	return true;
            }
        }
        
        return false;
    }
	
	// BFS - Time Limit Exceed !!!
	public boolean canJump_BFS(int[] A) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = A[index]; i > 0; i--) {
                if (index + i >= A.length - 1) {
                    return true;
                }
                if (i != 0)
                	queue.add(index + i);
            }
            System.out.println(queue.size());
        }
        
        return false;
    }
}
