package edu.nyu.liangfang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class twoSumDataStructure {
    // O(1) add, O(n) find
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    public boolean find(int value) {
        for (int key : map.keySet()) {
            int diff = value - key;

            if (diff == key) {
                if (map.get(key) > 1) return true;        // deal with duplicates
            } else if (map.containsKey(diff)) {
                return true;
            }
        }
        return false;
    }


    // O(n) add, O(1) find
    List<Integer> list = new LinkedList<Integer>();
    Set<Integer> set = new HashSet<Integer>();

    public void add2(int number) {
        if (list.size() != 0) {
            for (int n : list) {
                set.add(n + number);
            }
        }
        list.add(number);
    }

    public boolean find2(int value) {
        return set.contains(value);
    }
}
