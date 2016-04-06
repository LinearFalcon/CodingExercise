package edu.nyu.liangfang.leetcode;

public class firstMissingPositive {

    /*
     * 将数组A变成A[i] = i + 1的形式，第一个循环每次遇到A[i] != i+1且A[A[i] - 1] != A[i]，
     * 就swap，然后继续直到A[i]是负数或者等于i+1
     * 第二遍循环就扫描输出第一个不符合A[i] = i + 1的，即第一个missing的正整数
     *
     * 注意：如果输入是[9,4,-1,1],那9还是放在原地不动啊，跟-1的处理方式一样。最后全部调整结束之后是[1,4,-1,9]，返回2
     */
    public int firstMissingPositive(int[] A) {
        int i = 0;
        int n = A.length;
        while (i < n) {
            if (A[i] != i + 1 && A[i] >= 1 && A[i] <= n && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }

        for (int k = 0; k < n; k++) {
            if (A[k] != k + 1) {
                return k + 1;
            }
        }
        return n + 1;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
