public class bestTimeToBuyAndSellStockWithCooldown {

    // 使用state machine更有助于理解
    /*
    Three states: hold(之前买了股票), cooldown(前一天刚把股票卖了), empty(手中没有股票)
    Transition scenario:
    current hold: 1, empty -> hold(买了股票，-prices[i]); 2, hold -> hold(no action)
    current empty: 1, cooldown -> empty(只有可能从cooldown到empty，因为从hold卖出股票，一定要cooldown一天)
                   2, empty -> empty(no action)
    current cooldown: 1, hold -> cooldown(唯一的到cooldown的情况，卖出了股票，+prices[i])
    知道了每个点的三种情况后，均计算最大值，然后max profit就在这几种情况里面
    */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int[] hold = new int[prices.length];
        int[] cooldown = new int[prices.length];
        int[] empty = new int[prices.length];
        hold[0] = -prices[0];
        cooldown[0] = 0;
        empty[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], empty[i - 1] - prices[i]);
            cooldown[i] = hold[i - 1] + prices[i];
            empty[i] = Math.max(empty[i - 1], cooldown[i - 1]);
        }
        return Math.max(cooldown[prices.length - 1], empty[prices.length - 1]);
    }
}