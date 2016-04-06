package edu.nyu.liangfang.leetcode;

public class sortColors {
    // 1 pass and constant space
    public void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int index = 0;
        while (index <= right) {        // must equals !!! or [1, 0] will fail
            if (A[index] == 0) {
                swap(A, index, left);
                index++;                // because index starts from left, so at this time swap, we can increment index since only left value is swapped to this position
                left++;
            } else if (A[index] == 2) {
                swap(A, index, right);
                right--;
            } else {
                index++;
            }
        }
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    // 2 pass and O(n) space
    public void sortColors_2pass(int[] A) {
        int[] num = new int[3];
        for (int i = 0; i < A.length; i++) {
            num[A[i]]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (num[i] > 0) {
                A[index] = i;
                num[i]--;
                index++;
            }
        }
    }
}
