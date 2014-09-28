package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.List;

public class longgestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String s) {
		List<Character> subList = new ArrayList<Character>();
		int biggestLength = 0;

		int count = 0;
		for (int i = 0; i < s.length(); i++) {	
			char tmp = s.charAt(i);
			if (!subList.contains(tmp)) {
				count++;
				subList.add(tmp);
			} else {
				if (count > biggestLength) {
					biggestLength = count;
				}
				int index_of_repeat = subList.indexOf(tmp);
				count = count - index_of_repeat - 1;
				
				for (int j = 0; j <= index_of_repeat; j++ ) {
					subList.remove(0);
				}
				
				i--;
			}
		}
		
		// Consider the ending situation: longest substring is the last substring !!!!!!
		if (count > biggestLength) {
			biggestLength = count;
		}

		return biggestLength;
    }
}
