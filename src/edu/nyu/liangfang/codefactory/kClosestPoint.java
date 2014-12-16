package edu.nyu.liangfang.codefactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class kClosestPoint {
	
//	private Point o = new Point(2, 3);
	
	public List<Point> foo(int k, Point p, Point[] points) {
		List<Point> res = new ArrayList<Point>();
		final Point o = p;
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point n1, Point n2) {
				int num1 = Math.abs(n1.x - o.x) + Math.abs(n1.y - o.y);
				int num2 = Math.abs(n2.x - o.x) + Math.abs(n2.y - o.y);
				if (num1 < num2) {
					return 1;
				} else if (num1 > num2) {
					return -1;
				} else {
					return 0;
				}
			}
		}); 
		
		for (int i = 0; i < points.length; i++) {
			if (queue.size() < k) {
				queue.add(points[i]);
				continue;
			}
			
			Point n = points[i];
			int dist = Math.abs(n.x - o.x) + Math.abs(n.y - o.y);
			int peekDist = Math.abs(queue.peek().x - o.x) + Math.abs(queue.peek().y - o.y);
			if (dist < peekDist) {
				queue.poll();
				queue.add(n);
			}
		}
		
		while (!queue.isEmpty()) {
			res.add(0, queue.poll());
		}
		return res;
	}
	
}
