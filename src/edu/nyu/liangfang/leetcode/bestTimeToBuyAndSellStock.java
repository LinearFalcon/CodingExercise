package edu.nyu.liangfang.leetcode;

public class bestTimeToBuyAndSellStock {
	// O(n) time, O(1) space
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            profit = Math.max(p - min, profit);
        }
        return profit;
    }
	
	
	// O(n) time, O(n) space
	public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            leftMin[i] = min;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            rightMax[i] = max;
        }
        
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            if (rightMax[i] - leftMin[i] > maxProfit) {
                maxProfit = rightMax[i] - leftMin[i];
            }
        }
        return maxProfit;
    }
}
