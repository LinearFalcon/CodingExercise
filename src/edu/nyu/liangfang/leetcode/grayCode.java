package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class grayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<>();
        if (n == 0) {                           // grayCode(0) returns {0}
            rst.add(0);
            return rst;
        }

        List<Integer> prev = grayCode(n - 1);
        rst.addAll(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            rst.add(prev.get(i) + (int) Math.pow(2, n - 1));
        }
        return rst;
    }
}
