package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;


public class combinations {
    // DFS method
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        generate(n, k, 1, rst, tmp);
        return rst;
    }

    public void generate(int n, int k, int start, List<List<Integer>> rst, List<Integer> tmp) {
        if (tmp.size() == k) {
            rst.add(new LinkedList<Integer>(tmp));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            generate(n, k, i + 1, rst, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    // ----------------- V2 -----------------
    public List<List<Integer>> combine_dp(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (k > n || n < 1) {
            return result;
        }

        return fillList(k, 1, n);
    }

    private List<List<Integer>> fillList(int k, int start, int n) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (k <= 0) {
            list.add(new LinkedList<Integer>());
            return list;
        }

        for (int i = start; i <= n - k + 1; i++) {
            for (List<Integer> sub : fillList(k - 1, i + 1, n)) {
                sub.add(0, i);  // add to head
                list.add(sub);
            }
        }
        return list;
    }
}



