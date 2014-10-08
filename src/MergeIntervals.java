package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// Interval class defined in InsertInterval.java

public class MergeIntervals {
	// 简单方法
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals.size() == 0) {
            return result;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            } 
        });
        
        int least = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean justStart = true;
        for (Interval o : intervals) {
            if (o.start > max) {
                // 只有在发现这个interval跟之前的不重叠时，
                // 才把之前计算好的重叠的interval加进result
                if (!justStart) {   
                    result.add(new Interval(least, max));
                }
                least = o.start;
                max = o.end;
            } else {
                least = Math.min(least, o.start);	// 关键之处，重叠部分只用计算最小值和最大值
                max = Math.max(max, o.end);
            }
            if (justStart) {
                justStart = false;
            }
        }
        result.add(new Interval(least, max));
        return result;
    }
	
	public ArrayList<Interval> merge_complex(ArrayList<Interval> intervals) {
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
