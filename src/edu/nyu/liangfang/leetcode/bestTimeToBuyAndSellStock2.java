package edu.nyu.liangfang.leetcode;

public class bestTimeToBuyAndSellStock2 {
	// 只计算上升子序列差值
	public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (i != 0 && prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - min;
                min = prices[i];
            }
        }
        if (prices[prices.length - 1] > min) {
            profit += prices[prices.length - 1] - min;
        }
        return profit;
    }
	
	
	/*
	 在每次上升子序列之前买入，在上升子序列结束的时候卖出。相当于能够获得所有的上升子序列的收益。
	 而且，对于一个上升子序列，比如：5，1，2，3，4，0 中的1，2，3，4序列来说，对于两种操作方案：
     一，在1买入，4卖出；
     二，在1买入，2卖出同时买入，3卖出同时买入，4卖出；
     这两种操作下，收益是一样的。
	 */
	public int maxProfit2(int[] prices) {
        int p = 0;
        for(int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i-1];
            if(delta > 0 ) {
                p += delta;
            }
        }
        return p;
    }
}
