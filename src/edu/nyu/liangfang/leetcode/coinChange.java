public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minNum = new int[amount + 1];
        Arrays.fill(minNum, -1);
        minNum[0] = 0;
        for (int sum = 1; sum <= amount; sum++) {
            for (int coin : coins) {
                if (coin <= sum && minNum[sum - coin] != -1) {
                    if (minNum[sum] != -1)
                        minNum[sum] = Math.min(minNum[sum], 1 + minNum[sum - coin]);
                    else
                        minNum[sum] = 1 + minNum[sum - coin];
                }
            }
        }
        return minNum[amount];
    }
}