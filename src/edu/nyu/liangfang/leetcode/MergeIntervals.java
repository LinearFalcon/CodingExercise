package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// Interval class defined in InsertInterval.java

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();
        if (intervals.size() == 0) return rst;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) return a.end - b.end;
                else return a.start - b.start;
            }
        });
        
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval ele = intervals.get(i);
            if (intervals.get(i).start > end) {
                rst.add(new Interval(start, end));
                start = ele.start;
                end = ele.end;
            } else {                                      // 关键之处，重叠部分只用计算最小值和最大值
                start = Math.min(start, ele.start);
                end = Math.max(end, ele.end);
            }
        }
        rst.add(new Interval(start, end));
        return rst;
    }
}
