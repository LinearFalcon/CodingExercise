package edu.nyu.liangfang.codefactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 给一个int array，有正有负， 给一个target number，找出这个array里有没有连续的几个数之和等于target number 要用O(n) time
public class subArraySum {
    public void findSubArraySum(int[] A, int target) {
        if (A.length == 0) return;

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();    // key是从0到当前的sum，value是对应这个sum的下标
        int sumFromStart = 0;
        for (int i = 0; i < A.length; i++) {
            sumFromStart += A[i];
            if (sumFromStart == target) {        // 必须，因为下面的算法找的是两个valid的index，但是如果包含前面全部数字，则第一个index会是-1
                System.out.println(0 + " " + i);
                return;
            }

            int diff = sumFromStart - target;
            if (map.containsKey(diff)) {
                if (map.get(diff).get(0) < i) {
                    System.out.println((map.get(diff).get(0) + 1) + " " + i);
                    return;
                }
            }

            if (map.containsKey(sumFromStart)) {
                map.get(sumFromStart).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(sumFromStart, list);
            }
        }
    }


    // test
    public static void main(String[] args) {
        subArraySum o = new subArraySum();
        int[] A = {2, -3, 9, 5, -2};
        o.findSubArraySum(A, -1);
    }
}
