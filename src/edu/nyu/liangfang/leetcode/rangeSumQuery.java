public class NumArray {
    private int[] accu;
    public NumArray(int[] nums) {
        accu = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) accu[i] = nums[i];
            else {
                accu[i] = accu[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return accu[j];
        return accu[j] - accu[i - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);