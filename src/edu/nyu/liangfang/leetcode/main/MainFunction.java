package edu.nyu.liangfang.leetcode.main;

import java.util.HashSet;

import edu.nyu.liangfang.leetcode.WordLadder;


// Main class - Entrance
public class MainFunction {	
	public static void main(String[] args) {
		
		WordLadder obj = new WordLadder();

//		HashSet<String> set = new HashSet<String>();
//		set.add("hot");
//		set.add("dot");
//		set.add("dog");
//		set.add("lot");
//		set.add("log");
//		set.add("ait");
//        System.out.println(obj.ladderLength_DFS("hit", "cog", set));
		
		String s = "sd df";
		String[] arr = s.split("\\W+");
		System.out.println(arr[1]);
	}
	
}

