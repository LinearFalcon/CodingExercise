package edu.nyu.liangfang.leetcode;

public class bestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxVal = 0;
        int[] firstMaxProfit = new int[prices.length];    //firstMaxProfit[i]: max profit for one transaction in prices[0, i]
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            int diff = prices[i] - min;
            if (diff > maxVal)
                maxVal = diff;
            firstMaxProfit[i] = maxVal;
        }

        // Second scan, reverse scan and compute the max value of [i...n-1], 
        // then use firstMaxProfit to give maxProfit
        int maxProfit = 0;
        int max = Integer.MIN_VALUE;
        for (int j = prices.length - 1; j >= 0; j--) {
            if (prices[j] > max)
                max = prices[j];
            int diff = max - prices[j];
            if (diff + firstMaxProfit[j] > maxProfit)
                maxProfit = diff + firstMaxProfit[j];
        }

        return maxProfit;
    }
}
