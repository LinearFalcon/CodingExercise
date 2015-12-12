package edu.nyu.liangfang.leetcode;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/*
 * Program should output all string that's anagram in one list
 * e.g
 * Input: ["tea","and","ate","eat","dan"]
 * Output: ["dan","and","ate","eat","tea"]
 */

public class anagram {
	public List<String> anagrams(String[] strs) {
		Hashtable<String, List<String>> table = new Hashtable<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);

			if (table.containsKey(sorted)) {	// if already added this key
				table.get(sorted).add(strs[i]);
			} else {
				List<String> newList = new LinkedList<String>();
				newList.add(strs[i]);
				table.put(sorted, newList);
			}
		}

		List<String> result = new LinkedList<String>();
		for (String key : table.keySet()) {
			if (table.get(key).size() > 1)
				result.addAll(table.get(key));
		}
		return result;
	}
}
