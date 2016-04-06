package edu.nyu.liangfang.leetcode;

import java.util.Hashtable;

public class jumpGame2 {
    // Best solution
    /*
	 * We use "last" to keep track of the maximum index that has been reached
	 * by using the minimum steps "step", whereas "curr" is the maximum distance
	 * that can be reached by using "step+1" steps. Thus,
	 * curr = max(i+A[i]) where 0 <= i <= last.
	 */
    public int jump_best(int[] A) {
        // assume A can always been reached, if not, should check if (i > curr) and return -1
        int step = 0;
        int last = 0;    // max index that can be reached using 'step' steps
        int curr = 0;    // max index that can be reached by 'step + 1' steps
        for (int i = 0; i < A.length; i++) {
            if (i > last) {
                last = curr;
                step++;
            }
            curr = Math.max(curr, A[i] + i);
        }
        return step;
    }


    // my O(1) space, O(n) time solution
    public int jump_mine(int[] A) {
        if (A.length == 0) return -1;
        int step = 0;
        int preMax = 0, nextMax = 0;    // preMax: max index last step to; nextMax: max index next step to
        int i = 0;
        while (i < A.length) {
            // if (i > nextMax) {	// if assume we can always reach end, then no need for these lines
            //     return -1;
            // }
            if (i == A.length - 1)
                return step;

            nextMax = Math.max(nextMax, A[i] + i);    // keep updating nextMax in this step
            if (i == preMax) {                        // come to this step end
                preMax = nextMax;
                step++;
            }
            i++;
        }
        return step;
    }


    public int jump(int[] A) {
        // maxIndexOfStep.get(2) means farthest index can reach by 2 step
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
