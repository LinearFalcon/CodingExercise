package edu.nyu.liangfang.codefactory;
import java.util.HashMap;
import java.util.Map;


public class weightedRandomChoice {
	public static void main(String[] args) {
	    Map<String, Double> choices = new HashMap<String, Double>();
	    choices.put("foo", 0.5);
	    choices.put("bar", 0.3);
	    choices.put("baz", 0.2);
	    
	    //count for testing if it satisfies the possibility given
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (int i = 1000; i > 0; i--) {
        	String str = weightedRandomChoice(choices);
            if (count.containsKey(str))
                count.put(str, count.get(str) + 1);
            else
                count.put(str, 1);
        }
        System.out.println(count);
	}

	public static String weightedRandomChoice(Map<String, Double> choices) {
		String[] strs = new String[choices.size()];
		double[] accu = new double[choices.size()];		// accumulate array used to determine which index of string to return
		
		int i = 0;
		for (Map.Entry<String, Double> entry : choices.entrySet()) {
			strs[i] = entry.getKey();
			if (i == 0) {
				accu[i] = entry.getValue();
			} else {
				accu[i] = entry.getValue() + accu[i - 1];	
			}
			i++;
		}
		
		double rand = Math.random();
		return strs[search(accu, rand)];
	}

	// can also iterate once and return the index of first number that's bigger than or equal to target
	private static int search(double[] accu, double target) {
		int low = 0, high = accu.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (accu[mid] == target) {
				return mid;
			} else if (accu[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;		// always return the index of number that's bigger than target
	}
}
