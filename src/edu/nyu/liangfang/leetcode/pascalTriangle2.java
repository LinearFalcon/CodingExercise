package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class pascalTriangle2 {
	// O(rowIndex) extra space solution - only store prev
	public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return new LinkedList<Integer>();
        
        List<Integer> prev = new LinkedList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curr = new LinkedList<Integer>();
            if (i == 0) {
                curr.add(1);
            } else {
                curr.add(1);    // first 1 for this row
                for (int j = 1; j < prev.size(); j++) {
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
                curr.add(1);    // last 1 for this row
            }
            prev = curr;
        }
        
        return prev;
    }
    
	
	// O(n^2) space solution, depend on generateTriangle of question 1
	public List<Integer> getRow2(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (numRows < 1) {
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<Integer>();
            if (i == 0) {
                list.add(1);
                result.add(list);
            } else {
                list.add(1);    // first 1 for this row
                List<Integer> prev = result.get(i - 1);
                for (int j = 1; j < prev.size(); j++) {
                    list.add(prev.get(j) + prev.get(j - 1));
                }
                list.add(1);    // last 1 for this row
                result.add(list);
            }
        }
        
        return result;
    }
}
