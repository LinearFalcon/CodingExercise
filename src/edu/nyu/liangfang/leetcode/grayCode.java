package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class grayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<Integer>();
    if (n < 0) {
        return result;
    } else if (n == 0) {		// when n == 0, list should be [0]!!!!!
        result.add(0);
        return result;
    }
    
    List<Integer> prev = grayCode(n - 1);
    result.addAll(prev);
    for (int i = prev.size() - 1; i >= 0; i--) {		// must iterate in reverse order, because second half is symmetric
        result.add(prev.get(i) + (int)Math.pow(2, n - 1));
    }
    return result;
    }
}
