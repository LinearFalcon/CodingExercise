public class rotateArray {
    public void rotate_v1(int[] nums, int k) {
        if (nums.length == 0) return;

        int n = k % nums.length;
        int[] store = new int[n];
        for (int i = 0; i < n; i++) {
            store[i] = nums[nums.length - n + i];
        }
        for (int i = 0; i < nums.length - n; i++) {
            nums[nums.length - i - 1] = nums[nums.length - n - i - 1];
        }
        for (int i = 0; i < store.length; i++) {
            nums[i] = store[i];
        }
    }


}