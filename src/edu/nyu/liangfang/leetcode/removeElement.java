package edu.nyu.liangfang.leetcode;

public class removeElement {
    public int removeElement(int[] A, int elem) {
        int last = A.length - 1;
        int index = 0;

        while (index <= last) {
            if (A[index] != elem) {
                index++;
            } else {
                A[index] = A[last];
                last--;
            }
        }
        return last + 1;
    }
}
