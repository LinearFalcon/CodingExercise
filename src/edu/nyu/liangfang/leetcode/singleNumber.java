package edu.nyu.liangfang.leetcode;

// Given an array of integers, every element appears twice except for one. Find that single one.

public class singleNumber {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int n : A) {
            res = res ^ n;
        }
        return res;
    }
}
