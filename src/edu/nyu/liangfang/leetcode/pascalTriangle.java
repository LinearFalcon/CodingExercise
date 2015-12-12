package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class pascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (numRows < 1) {
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<Integer>();
            if (i == 0) {
                list.add(1);
                result.add(list);
            } else {
                list.add(1);    // first 1 for this row
                List<Integer> prev = result.get(i - 1);
                for (int j = 1; j < prev.size(); j++) {
                    list.add(prev.get(j) + prev.get(j - 1));
                }
                list.add(1);    // last 1 for this row
                result.add(list);
            }
        }
        
        return result;
    }
}
