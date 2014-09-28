package edu.nyu.liangfang.leetcode;

import java.util.Hashtable;

public class jumpGame2 {
	public int jump(int[] A) {
		// maxIndexOfStep[2] means farthest index can reach by 2 step
        Hashtable<Integer, Integer> maxIndexOfStep = new Hashtable<Integer, Integer>();
        maxIndexOfStep.put(0, 0);
        
        int step = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > maxIndexOfStep.get(step)) {
                step++;
            }
            
            // for index that we can reach in step, we find biggest index we can reach by step + 1
            if (maxIndexOfStep.containsKey(step + 1)) {
                if (i + A[i] > maxIndexOfStep.get(step + 1)) {
                    maxIndexOfStep.put(step + 1, i + A[i]);
                }
            } else {
                maxIndexOfStep.put(step + 1, i + A[i]);
            }
        }
        
        return step;
    }
}
