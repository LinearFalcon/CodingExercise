public class houseRobber {
	// notRob -> max money that not rob last house
	// rob -> max money that rob last house
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        
        int notRob = 0, rob = nums[0];	
        for (int i = 1; i < nums.length; i++) {
            int tmpNotRob = Math.max(notRob, rob);
            int tmpRob = nums[i] + notRob;
            notRob = tmpNotRob;
            rob = tmpRob;
        }
        return Math.max(rob, notRob);
    }
}