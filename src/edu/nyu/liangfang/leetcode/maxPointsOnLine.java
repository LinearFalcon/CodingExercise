package edu.nyu.liangfang.leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class Point {
	 int x;
	 int y;
	 Point() { x = 0; y = 0; }
	 Point(int a, int b) { x = a; y = b; }
}


public class maxPointsOnLine {
	// my version
	public int maxPoints_v2(Point[] points) {
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Float, Integer> map = new HashMap<Float, Integer>();
            int dup = 1;			// at least there is one point p itself
            
            Point p = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point q = points[j];
                float slope;
                
                if (p.x == q.x && p.y == q.y) {
                    dup++;
                    continue;
                } else if (p.x == q.x) {
                    slope = Float.MAX_VALUE;
                } else {
                    slope = (float)(0.0 + (float)(p.y - q.y) / (float)(p.x - q.x));
                }
                
                if (!map.containsKey(slope)) {			// count how many other points is on the line with slope
                    map.put(slope, 1);
                } else { 
                    map.put(slope, map.get(slope) + 1);
                }
            }
            
            max = Math.max(max, dup);				// it's possible all other points are in the same position as point p, 
            for (int num : map.values()) {			// so map is empty, we need to first use 'dup' to update max !!!
                max = Math.max(max, dup + num);
            }
        }
        return max;
    }
	
	// answer
	public int maxPoints(Point[] points) {

        int max = 0;	
        // check each line start by this point
        for (int i = 0; i < points.length; i++) {
        	Hashtable<Float, Integer> table = new Hashtable<Float, Integer>();
        	int dup = 0;
        	
        	// It's possible that all points are on the same point, same point is
        	// represented by MIN_VALUE
        	table.put(Float.MIN_VALUE, 1);

        	// 因为如果当前点points[i]在最长那条line上，那么对于这条line上的其他点，就没有必要再与i做重复计算，所以
        	// 可以适当pruning，从i + 1开始，不过time仍然是 O(n^2)
            for (int j = i + 1; j < points.length; j++) {
                float slope;
                
                // If encouter point in same position
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                	dup++;
                	continue;
                }
                
                if (points[j].x == points[i].x) {
                    slope = Float.MAX_VALUE;		// vertical line
                } else {
                	// because (float)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
 	                // problem !!!!!!
                    slope = (float)(0.0 + (float)((points[j].y - points[i].y) / (float)(points[j].x - points[i].x)));
                }
                                
                if (!table.containsKey(slope)) {
                	table.put(slope, 2);		// point p and point q, so should put 2 rather than 1
                } else {
                	table.put(slope, table.get(slope) + 1);
                }                
                
            }
            
            // after computing for this node, check if we need to update max
            for (int num : table.values()) {
            	max = Math.max(max, num + dup);
            }
        }
        

        return max;
    }
}
