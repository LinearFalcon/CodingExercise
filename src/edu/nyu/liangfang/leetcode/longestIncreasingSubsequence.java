public class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] lisEndAt = new int[nums.length];
        Arrays.fill(lisEndAt, 0, lisEndAt.length, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    lisEndAt[i] = Math.max(lisEndAt[i], 1 + lisEndAt[j]);
            }
            res = Math.max(res, lisEndAt[i]);
        }
        return res;
    }
}