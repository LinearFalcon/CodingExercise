import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Interval class defined in InsertInterval.java

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		int length = intervals.size();
		if (length < 2)
			return intervals;
		
		Collections.sort(intervals, new Comparator<Interval>() {	// use comparator to sort ArrayList
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				} else {
					return o1.start - o2.start;
				}
			}	
		});
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval pre = intervals.get(0);
		int i = 1;
		
		while (i < length) {					// Use outer while loop to process repeated situation
			while (i < length && pre.end < intervals.get(i).start) {
				
				result.add(pre);
				pre = intervals.get(i);
				i++;
			}	
			if (i >= length)		// If i >= length, then should add last pre into result
				result.add(pre);
			else {
				while(i < length && pre.end >= intervals.get(i).start) {
					pre.start = Math.min(pre.start, intervals.get(i).start);
					pre.end = Math.max(pre.end, intervals.get(i).end);
					i++;
				}
				if (i >= length)    // If i >= length, then should add last pre into result
					result.add(pre);
			}
		}
		return result;
	}

}
