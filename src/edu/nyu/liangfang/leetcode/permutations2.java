package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class permutations2 {
    // DFS
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num.length == 0) return rst;

        Arrays.sort(num);       // must sort array first
        boolean[] visited = new boolean[num.length];
        List<Integer> curr = new ArrayList<Integer>();

        generate(num, rst, curr, visited);

        return rst;
    }

    public void generate(int[] num, List<List<Integer>> rst, List<Integer> curr, boolean[] visited) {
        if (curr.size() == num.length) {
            rst.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            // 只有当当前数字没有被访问过且它的前一个数字不相同或者相同但是访问过了，才能添加这个数字
            if (visited[i] || (i > 0 && num[i] == num[i - 1] && !visited[i - 1])) {
                continue;
            }

            curr.add(num[i]);
            visited[i] = true;
            generate(num, rst, curr, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    // AC method - DFS   -  easy to understand
    // Hashtable to store <number, appear times> pair, then just like construct
    // trees, each time pick a key to add to list and decrement value of this key in Hashtable
    // until this branch finish (table becomes empty), so we avoid duplicate and sort
    public List<List<Integer>> permuteUnique_2(int[] num) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < num.length; i++) {
            if (!table.containsKey(num[i])) {
                table.put(num[i], 1);
            } else {
                table.put(num[i], table.get(num[i]) + 1);
            }
        }

        getPerm(num, table, result, new LinkedList<Integer>());
        return result;
    }

    public void getPerm(int[] num, Hashtable<Integer, Integer> table,
                        List<List<Integer>> result, List<Integer> list) {

        if (table.isEmpty()) {
            result.add(list);
            return;
        }

        for (int key : table.keySet()) {
            List<Integer> cloneList = new LinkedList<Integer>(list);
            Hashtable<Integer, Integer> cloneTable = new Hashtable<Integer, Integer>(table);
            if (cloneTable.get(key) == 1) {
                cloneTable.remove(key);
            } else {
                cloneTable.put(key, cloneTable.get(key) - 1);
            }

            cloneList.add(key);
            getPerm(num, cloneTable, result, cloneList);
        }
    }


    // ---------------- TLE method -----------------
    public List<List<Integer>> permuteUnique3(int[] num) {
        if (num.length == 0) {
            return new LinkedList<List<Integer>>();
        }
        Arrays.sort(num);
        return perm(num, num.length - 1);
    }

    public List<List<Integer>> perm(int[] num, int index) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (index == -1) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        List<List<Integer>> prev = perm(num, index - 1);
        for (List list : prev) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> tmp = new LinkedList<Integer>(list);
                if (i == list.size() || tmp.get(i) != num[index]) {
                    tmp.add(i, num[index]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
