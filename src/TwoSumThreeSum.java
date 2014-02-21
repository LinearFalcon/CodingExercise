import java.util.Arrays;
import java.util.Hashtable;
import java.util.ArrayList;

public class TwoSumThreeSum {

	public int[] twoSum(int[] numbers, int target) {				//Since hashtable.containsKey operation only takes O(1), so we use it to avoid iterating array each time
		int[] result = new int[2];
        Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	
        	if (table.containsKey(target - numbers[i])) {
        		int n = table.get(target - numbers[i]);
        		if (n < i) {
        			result[0] = n + 1;
        			result[1] = i + 1;
        			return result;
        		}
        	}
        	table.put(numbers[i], i);
        }
        return result;
    }
	
	public ArrayList<ArrayList<Integer>> threeSumWithHashtable(int[] num) {		// Too much time cost!!!!!!!!!
//		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < num.length; i++) {
			Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
			int rest = 0 - num[i];
			for (int j = 0; j < i; j++) {
				if (table.containsKey(rest - num[j])) {
					int v1 = num[i];
					int v2 = num[j];
					int v3 = rest - num[j];
					ArrayList<Integer> set = new ArrayList<Integer>();
					if (v1 >= v2) {
						if (v2 <= v3 && v3 >= v1) {
							set.add(v2);
							set.add(v1);
							set.add(v3);
						} else if (v2 <= v3 && v3 < v1) {
							set.add(v2);
							set.add(v3);
							set.add(v1);
						} else {
							set.add(v3);
							set.add(v2);
							set.add(v1);
						}
					} else {	
						if (v2 > v3 && v3 >= v1) {
							set.add(v1);
							set.add(v3);
							set.add(v2);
						} else if (v2 > v3 && v3 < v1) {
							set.add(v3);
							set.add(v1);
							set.add(v2);
						} else {
							set.add(v1);
							set.add(v2);
							set.add(v3);
						}
					}
					if (!result.contains(set)) {
						result.add(set);
					}
				}
				table.put(num[j], j);
			}
		}
		return result;
    }

	public ArrayList<ArrayList<Integer>> threeSumNoHash(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return result;	
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i -1])
				continue;
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int a = num[i];
				int b = num[left];
				int c = num[right];
				int sum = a + b +c;
				if (sum == 0) {
					ArrayList<Integer> set = new ArrayList<Integer>();
					set.add(a);
					set.add(b);
					set.add(c);

					result.add(set);

					do {
						left++;
					} while (left < right && num[left] == num[left - 1]);
					do {
						right--;
					} while (left < right && num[right] == num[right + 1]);
				} else if (sum > 0) {
					right = right - 1;
				} else {
					left = left + 1;
				}
			}
		}
		return result;
	}
}
