package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class grayCode {
	public List<Integer> grayCode(int n) {
        if (n < 0) {
            return new LinkedList<Integer>();
        }
        if (n == 0) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(0);
            return list;
        }
        
        List<Integer> result = new LinkedList<Integer>();
        List<Integer> prevList = grayCode(n - 1);
        
        // except for first digit, remainings are symmetrical
        for (int i = 0; i < prevList.size(); i++) {
            result.add(prevList.get(i));
        }
        for (int i = prevList.size() - 1; i >= 0; i--) {
            result.add(prevList.get(i) + (int)Math.pow(2, n - 1));
        }
        return result;
    }
}
