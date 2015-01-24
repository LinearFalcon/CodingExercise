package edu.nyu.liangfang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class romanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int curr = 0;
        int pre = Integer.MAX_VALUE;
        int rst = 0;
        for (int i = 0; i < s.length(); i++) {
            curr = map.get(s.charAt(i));
            if (curr > pre) {
                rst -= 2 * pre;
            }
            rst += curr;
            pre = curr;
        }
        return rst;
    }
}
