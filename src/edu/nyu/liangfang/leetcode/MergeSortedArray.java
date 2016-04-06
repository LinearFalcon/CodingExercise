package edu.nyu.liangfang.leetcode;

public class MergeSortedArray {
    public void merge(int nums1[], int m, int num2[], int n) {
        int p = m - 1, q = n - 1;
        int pointer = m + n - 1;
        while (pointer >= 0) {
            if (p < 0) nums1[pointer] = nums2[q--];
            else if (q < 0) nums1[pointer] = nums1[p--];
            else if (nums1[p] > nums2[q]) nums1[pointer] = nums1[p--];
            else if (nums1[p] <= nums2[q]) nums1[pointer] = nums2[q--];
            pointer--;
        }
    }
}
