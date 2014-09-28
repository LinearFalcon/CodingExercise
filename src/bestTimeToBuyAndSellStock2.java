package edu.nyu.liangfang.leetcode;

public class bestTimeToBuyAndSellStock2 {
	public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        
        // max profit you can get until each day
        int[] maxProfit = new int[prices.length];
        maxProfit[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            
            // if price go up, max profit is max profit get by yesterday plus new profit
            if (prices[i] > prices[i - 1])
                maxProfit[i] = maxProfit[i - 1] + prices[i] - prices[i - 1];
            // if price go down, max profit can get by today should be equal to yesterday    
            else
                maxProfit[i] = maxProfit[i - 1];
        }
        
        return maxProfit[prices.length - 1];
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
