public class moveZeroes {
    // simple way
    /*
	 * scan the array, use a index to mark the position to be assigned from left. 
	 * Everytime copy the non-zero value to array[index] and increment index by 1. 
	 * At last, just assign 0 to rest of array which is [index:end]
	 */
    public void moveZeroes_simple(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        Arrays.fill(nums, index, nums.length, 0);
    }


    // two pointer method, too complicated
    public void moveZeroes_original(int[] nums) {
        if (nums == null) return;

        int p = 0;
        int q = 0;
        while (q < nums.length) {
            while (p < nums.length && nums[p] != 0) {
                p++;
            }
            if (p >= nums.length - 1) {
                break;
            }
            while (q <= p || (q > p && q < nums.length && nums[q] == 0)) {
                q++;
            }
            if (q >= nums.length) {
                break;
            }
            int tmp = nums[p];
            nums[p] = nums[q];
            nums[q] = tmp;
            p++;
            q++;
        }
    }
}