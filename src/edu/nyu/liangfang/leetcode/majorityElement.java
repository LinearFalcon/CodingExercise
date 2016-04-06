public class majorityElement {
    // Better solution - Voting algorithm O(n) time O(1) space
    public int majorityElement_voting_algo(int[] nums) {
        int count = 1;
        int majNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majNum) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majNum = nums[i + 1];
                count = 1;
                i++;
            }
        }
        return majNum;
    }


    // My O(n) space solution
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) map.put(n, 1);
            else map.put(n, 1 + map.get(n));
        }
        for (int k : map.keySet()) {
            if (map.get(k) > nums.length / 2)
                return k;
        }
        return -1;
    }
}