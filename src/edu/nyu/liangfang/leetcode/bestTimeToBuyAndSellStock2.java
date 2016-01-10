package edu.nyu.liangfang.leetcode;

public class bestTimeToBuyAndSellStock2 {
    /*
     在每次上升子序列之前买入，在上升子序列结束的时候卖出。相当于能够获得所有的上升子序列的收益。
     而且，对于一个上升子序列，比如：5，1，2，3，4，0 中的1，2，3，4序列来说，对于两种操作方案：
     一，在1买入，4卖出；
     二，在1买入，2卖出同时买入，3卖出同时买入，4卖出；
     这两种操作下，收益是一样的。
     */
	// 只计算上升子序列差值
	public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
