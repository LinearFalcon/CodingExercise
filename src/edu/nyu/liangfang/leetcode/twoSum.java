package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;

public class twoSum {

	public int[] twoSum(int[] numbers, int target) {				//Since hashtable.containsKey operation only takes O(1), so we use it to avoid iterating array each time
		int[] result = new int[2];
        Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (table.containsKey(numbers[i])) {
                result[0] = table.get(numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            table.put(target - numbers[i], i);
        }
        return result;
    }
	
}