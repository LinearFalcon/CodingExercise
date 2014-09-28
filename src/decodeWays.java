package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;


public class decodeWays {
	public int numDecodings(String s) {
		if (s.length() <= 0)
			return 0;
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		return getNum(s.length(), s, table);        
	}

	private int getNum(int len, String remainingStr, Hashtable<String, Integer> table) {
		if (len < 0)
			return 0;
		if (len == 0)		// indicating this branch succeed so return 1
			return 1;
		if (remainingStr.charAt(0) - '0' == 0)
			return 0;
		if (table.containsKey(remainingStr))			// dynamic programming: avoid repeated computing
			return table.get(remainingStr);

		int num;
		if (len == 1) {
			num = getNum(len - 1, remainingStr.substring(1), table);
		} else {
			int valueOfTwoDigits = (remainingStr.charAt(0) - '0') * 10 + (remainingStr.charAt(1) - '0');
			
			if (valueOfTwoDigits > 26) {
				num = getNum(len - 1, remainingStr.substring(1), table);
			} else {
				num = getNum(len - 1, remainingStr.substring(1), table) + getNum(len - 2, remainingStr.substring(2), table);
			}

		}
		table.put(remainingStr, num);
		return num;
	}
}

/*
 *  For "1234", after computing branch 1234-234-34-4-"", we get 1 and table.get(4) == table.get(34) == 1;
 *  Then in later compute, we don't need to recursion to compute other half of the tree, just retrieve value from hashtable.
 */
