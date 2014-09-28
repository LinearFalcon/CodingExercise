package edu.nyu.liangfang.leetcode;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;





// Main class - Entrance
public class MainFunction {	
	public static void main(String[] args) {
		
		zigZagConversion obj = new zigZagConversion();

		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		
		int[] num = {0};
		
		Hashtable<Integer,Integer> t1 = new Hashtable<Integer,Integer>();
		Hashtable<Integer,Integer> t2 = new Hashtable<Integer,Integer>();
		
		t2.put(2, 3);
		t2.put(2, 5);
		t1.putAll(t2);
		
		char[][] board = {{'O','X','X','O','X'},
				          {'X','O','O','X','O'},
				          {'X','O','X','O','X'},
				          {'O','X','O','O','O'},
				          {'X','X','O','X','O'}};

		Point[] arr = {new Point(0,0),new Point(1,1),new Point(-1,-1)};
		
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		
		int[][] matrix = {{1,2},{3,4}};
		
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		list.add(-10);
		triangle.add(list);
		
		System.out.println(obj.convert("PAYPALISHIRING", 3));

	}
	
}

