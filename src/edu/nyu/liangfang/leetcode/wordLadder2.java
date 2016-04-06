package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class wordLadder2 {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        // value is a list of strings that can transfrom from them to key string in one step
        Map<String, List<String>> backMap = new HashMap<String, List<String>>();
        // shortest distance from start to this key string
        Map<String, Integer> distance = new HashMap<String, Integer>();

        // dict.add(start);   // do not need this
        dict.add(end);

        bfs(start, end, dict, backMap, distance);
        // dfs backtrace, starting from end
        List<String> list = new ArrayList<String>();
        backtrack(start, end, result, backMap, distance, list);

        return result;
    }

    // Backtrace and get all path from backMap
    public void backtrack(String start, String curr, List<List<String>> result,
                          Map<String, List<String>> backMap, Map<String, Integer> distance, List<String> list) {

        list.add(0, curr);
        if (curr.equals(start)) {
            result.add(list);
            return;
        }

        for (String next : backMap.get(curr)) {
            if (distance.containsKey(next) && distance.get(curr) == distance.get(next) + 1) {    // assure it is shortest path
                List<String> clone = new ArrayList<String>(list);
                backtrack(start, next, result, backMap, distance, clone);
            }
        }
    }

    // BFS traverse and initialize backMap and distance
    public void bfs(String start, String end, Set<String> dict,
                    Map<String, List<String>> backMap, Map<String, Integer> distance) {

        // initialize distance<start, start> to 0
        distance.put(start, 0);
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        for (String s : dict) {             // initialize backMap
            backMap.put(s, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            List<String> nextList = getNextStr(curr, dict);
            for (String next : nextList) {
                backMap.get(next).add(curr);
                if (!distance.containsKey(next)) {  // make sure only store shortest distance
                    distance.put(next, distance.get(curr) + 1);
                    queue.add(next);
                }
            }
        }
    }

    // Return a list of string that can transform from curr to
    public List<String> getNextStr(String curr, Set<String> dict) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < curr.length(); i++) {
            char[] arr = curr.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != curr.charAt(i)) {
                    arr[i] = ch;
                    String newStr = new String(arr);
                    if (dict.contains(newStr)) {
                        list.add(newStr);
                    }
                }
            }
        }
        return list;
    }
}