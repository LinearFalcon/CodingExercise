import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();	
		Queue<Integer> count = new LinkedList<Integer>();	
		Set<String> visited = new HashSet<String>();
		
		queue.add(start);
		count.add(1);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			
			String s = queue.poll();
			int layer = count.poll();
			
//			if (s.compareTo(end) == 0)			if assume end is in dict
//				return layer;
			if (canTransform(s, end))			// if end is not in dict, then need this helper function to determine if can transform
				return layer + 1;
			
			for (int i = 0; i < s.length(); i++) {				// do not use iterator to iterate whole dict, since dict could be large
				for (char temp = 'a'; temp <= 'z'; temp++) {
					char[] sArr = s.toCharArray();
					sArr[i] = temp;
					String s2 = new String(sArr);
					
					if (dict.contains(s2) && !visited.contains(s2)) {
						queue.add(s2);
						count.add(layer + 1);
						visited.add(s2);
					}
					
				}
			}				
		}
		return 0;
    }

	public boolean canTransform(String s1, String s2) {		
		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				diff++;
		}
		if (diff == 1)
			return true;
		return false;
	}
}
