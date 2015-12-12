package edu.nyu.liangfang.leetcode;
import java.util.Hashtable;


/*
 *  For "1234", after computing branch 1234-234-34-4-"", we get 1 and table.get(4) == table.get(34) == 1;
 *  Then in later compute, we don't need to recursion to compute other half of the tree, just retrieve value from hashtable.
 */
public class decodeWays {
	// DP - Iterative, most efficient
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {		// Must Check if first digit is 0 !!!!!!!!!!
            return 0;
        }
        int[] dp = new int[s.length() + 1]; // 前n个digit的decode种类数
        
        dp[0] = 1;  // indicate succeed when no left char
        dp[1] = 1;  // because s.charAt(0) is not '0'
        
        for (int i = 2; i <= s.length(); i++) {
        	if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            
            int num = Integer.valueOf(s.substring(i - 2, i));
            if (num <= 26 && num >= 10) {		// num >= 10 means s.charAt(i - 2) is not '0'
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }

	// DP - recursion
	public int numDecodings_recursion(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return getNum(s, new Hashtable<String, Integer>());
    }
    
    public int getNum(String s, Hashtable<String, Integer> table) {
        if (s.length() == 0) {			// indicating this branch succeed so return 1
            return 1;
        }
        if (table.containsKey(s)) {		// dynamic programming: avoid repeated computing
            return table.get(s);
        }
        if (s.charAt(0) == '0') {   	// process "01" situation
            return 0;
        }
        
        int num = 0;
        if (s.length() == 1) {  // only one digit, it can be counted definitely
            num += getNum(s.substring(1), table);
        } else {
            int valueOfTwoDigits = Integer.valueOf(s.substring(0, 2));
            num += getNum(s.substring(1), table) + 
                    ((valueOfTwoDigits >= 1 && valueOfTwoDigits <= 26) ? getNum(s.substring(2), table) : 0);
        }
        table.put(s, num);
        return num;
    }
}

