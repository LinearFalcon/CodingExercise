package edu.nyu.liangfang.codefactory;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class medianOfStreamingInteger {
    PriorityQueue<Integer> leftQ;
    PriorityQueue<Integer> rightQ;
    int median;

    public medianOfStreamingInteger() {
        leftQ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {        // Max-heap, 10 is just initial room, priority queue will expand automatically
            public int compare(Integer n1, Integer n2) {
                return n2.intValue() - n1.intValue();
            }
        });

        rightQ = new PriorityQueue<Integer>();        // Min-heap
        median = Integer.MAX_VALUE;
    }

    public void addOneNumber(int num) {
        if (num > median) {
            rightQ.add(num);
            if (rightQ.size() - leftQ.size() > 1) {
                leftQ.add(rightQ.poll());
            }
        } else {
            leftQ.add(num);
            if (leftQ.size() - rightQ.size() > 1) {
                rightQ.add(leftQ.poll());
            }
        }


        if (leftQ.size() > rightQ.size()) median = leftQ.peek();
        else if (leftQ.size() < rightQ.size()) median = rightQ.peek();
        else median = (leftQ.peek() + rightQ.peek()) / 2;

        System.out.println(getMedian());
    }

    public int getMedian() {
        if (median == Integer.MAX_VALUE) {
            throw new NoSuchElementException("No median!");
        }

        return median;
    }


    // ------ test ------
    public static void main(String[] args) {
        medianOfStreamingInteger o = new medianOfStreamingInteger();

        o.addOneNumber(5);
        o.addOneNumber(3);
        o.addOneNumber(7);
        o.addOneNumber(8);
        o.addOneNumber(2);

    }
}
