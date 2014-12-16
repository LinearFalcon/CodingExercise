package edu.nyu.liangfang.codefactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class transformOneWordToAnother_cc150_ch18_10 {
	// CC150 answer, assume only lowercase 
	public List<String> transform(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Map<String, String> backtrackMap = new HashMap<String, String>();
		
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			String old = queue.poll();
			for (String newStr : getAllNextStr(old)) {
				if (newStr.equals(end)) {
					List<String> result = new LinkedList<String>();
					result.add(0, newStr);
					while (old != null) {
						result.add(0, old);
						old = backtrackMap.get(old);
					}
					return result;
				} 

				if (dict.contains(newStr)) {
					if (!visited.contains(newStr)) {
						visited.add(newStr);
						queue.add(newStr);
						backtrackMap.put(newStr, old);
					}
				}
			}
		}
		return null;
	}

	// get all strings that can be transformed from old string 
	private Set<String> getAllNextStr(String old) {
		Set<String> res = new HashSet<String>();
		for (int i = 0; i < old.length(); i++) {
			char[] arr = old.toCharArray();
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (old.charAt(i) != ch) {
					arr[i] = ch;
					res.add(new String(arr));
				}
			}
		}
		return res;
		
	}
}
