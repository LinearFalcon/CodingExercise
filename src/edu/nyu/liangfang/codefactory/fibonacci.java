package edu.nyu.liangfang.codefactory;

public class fibonacci {
    public int fibonacciNum_recursion(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        return fibonacciNum_recursion(n - 1) + fibonacciNum_recursion(n - 2);
    }

    public int fibonacci_iterative(int n) {
        int first = 1;
        int second = 1;
        if (n < 3) {
            return 1;
        }

        int count = 2;
        while (count < n) {
            int tmp = first;
            first = first + second;
            second = tmp;
            count++;
        }
        return first;
    }

    public int fibonacci_DP(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
