public class containsDuplicate2 {
    // Because we scan from left to right, we do not need to store all indice associated with the same value.
    // HashMap<value, index>: As soon as we find a index that its value exists in HashMap's keyset, we can
    // compare these two index. If <= k then return true, or just assign new index to this key.
    // Time: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }

    // pass version O(n) but it takes a lot of time, too complicated
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }

        for (List<Integer> l : map.values()) {                // !! We must explicitly specify type is Integer, or 'l.get(i) - l.get(i - 1)' throw error
            if (l.size() >= 2) {
                for (int i = 1; i < l.size(); i++) {
                    if (l.get(i) - l.get(i - 1) <= k) return true;
                }
            }
        }
        return false;
    }

    // Time: O(nk)
    public boolean containsNearbyDuplicate_TLE(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (j < nums.length && nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}