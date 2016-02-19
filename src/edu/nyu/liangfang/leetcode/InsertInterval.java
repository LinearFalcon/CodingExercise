package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.List;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {
	// v1
	public List<Interval> insert_v1(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start, end = newInterval.end;
        List<Interval> rst = new ArrayList<>();
        boolean inserted = false;
        for (Interval o : intervals) {
            if (o.end < start) rst.add(o);
            else if (o.start > end) {
                if (!inserted) {
                    rst.add(new Interval(start, end));
                    inserted = true;
                } 
                rst.add(o);							// don't forget you need to add o everytime!
            } else {
                start = Math.min(start, o.start);
                end = Math.max(end, o.end);
            }
        }
        if (!inserted) rst.add(new Interval(start, end));
        return rst;
    }


	// v2
	public List<Interval> insert_v2(ArrayList<Interval> intervals, Interval newInterval) {
		int length = intervals.size();
		List<Interval> result = new ArrayList<Interval>();
		int i = 0;
		// Insert intervals before overlap
	    while(i < length && newInterval.start > intervals.get(i).end) {		
	        result.add(intervals.get(i));
	        i++;
	    }
	    // Before overlap finish, change start and end
	    while(i < length && newInterval.end >= intervals.get(i).start) {   
	    	newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
	        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
	        i++;
	    }
	    // Add modified newInterval
	    result.add(newInterval);        
	    // Add rest of intervals which is not overlapped
	    while(i < length) {				
	    	result.add(intervals.get(i));
	    	i++;
	    }
		return result;
    }
}
