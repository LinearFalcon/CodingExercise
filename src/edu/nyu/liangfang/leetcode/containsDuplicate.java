public class containsDuplicate {
    // Set solution
    public boolean containsDuplicate_set(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

    // Sort solution
    public boolean containsDuplicate_sort(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}