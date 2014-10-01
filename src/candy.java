package edu.nyu.liangfang.leetcode;

public class candy {
	public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        // scan from left to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        
        // scan from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        // compute result
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
