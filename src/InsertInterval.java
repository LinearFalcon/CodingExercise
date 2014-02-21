import java.util.ArrayList;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int length = intervals.size();
		ArrayList<Interval> result = new ArrayList<Interval>();
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
