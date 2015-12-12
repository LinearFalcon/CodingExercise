package edu.nyu.liangfang.codefactory;

import java.util.PriorityQueue;

/*
 * Given an array of meetings, find out the minimum number of conference rooms required.
 */

class Meeting {
	long startTime;
    long endTime;
    Meeting(long t1, long t2) {
    	startTime = t1;
    	endTime = t2;
    }
};

// 基本思想：把开始时间和结束时间排好，然后一路扫过去，遇到start加1，遇到end减1，这中间的最大值就是最小房间数
// Time: O(nlgn)
public class minNumberOfConferenceRoom {
	public int minNumberOfRoom(Meeting[] meetings) {
		int numOfRoom = 0;
		PriorityQueue<Long> startTime = new PriorityQueue<Long>();
		PriorityQueue<Long> endTime = new PriorityQueue<Long>();
		
		for (Meeting m : meetings) {
			startTime.add(m.startTime);
			endTime.add(m.endTime);
		}
		
		int room = 0;
		while (!startTime.isEmpty() && !endTime.isEmpty()) {
			long start = startTime.peek();
			long end = endTime.peek();
			if (start == end) {
				startTime.poll();
				endTime.poll();
			} else if (start < end) {
				startTime.poll();
				room++;
				numOfRoom = Math.max(numOfRoom, room);
			} else {
				endTime.poll();
				room--;
			}
		}
		
		// actually it's possible that endTime priority queue is not empty,
		// but it doesn't matter since we only care about max room value during this process
		
		return numOfRoom;
	}
	
	// test
	public static void main(String[] args) {
		minNumberOfConferenceRoom obj = new minNumberOfConferenceRoom();
//		Meeting[] m = {new Meeting(1,5), new Meeting(3,8), new Meeting(4,9), new Meeting(2,4), new Meeting(3,4)};
		Meeting[] m = {new Meeting(1,4), new Meeting(4,8), new Meeting(0,9)};
		System.out.println(obj.minNumberOfRoom(m));
	}
}
