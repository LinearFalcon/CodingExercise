package edu.nyu.liangfang.codefactory;
/*

找出一个数由最少几个平方的和的组成
例子：
input： 14    output:  9 ,4 , 1  虽然也能由1 +1 +....+1组成 但长度是14 不是最优解
input:   50     ouput :  25, 25 
 */

public class minNumberOfSqureSum {
    public static int minNum(int n) {
        int[] dp = new int[n + 1];    // dp[i] means minimum number of square that sum up to i
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k <= Math.sqrt(i); k++) {
                int num = 1 + dp[i - k * k];
                min = Math.min(min, num);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minNum(10));
    }
}
