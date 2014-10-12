package edu.nyu.liangfang.leetcode.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.nyu.liangfang.leetcode.wildcardMatching;
import edu.nyu.liangfang.leetcode.wordLadder2;


// Main class - Entrance
public class MainFunction {	
	public static void main(String[] args) {
		
		wildcardMatching obj = new wildcardMatching();
		
		int[] num = {0};
	
		char[][] board = {{'O','X','X','O','X'},
				          {'X','O','O','X','O'},
				          {'X','O','X','O','X'},
				          {'O','X','O','O','O'},
				          {'X','X','O','X','O'}};
		
		char[][] tokens = {".....7..9".toCharArray(),
						   ".4..812..".toCharArray(),
						   "...9...1.".toCharArray(),
						   "..53...72".toCharArray(),
						   "293....5.".toCharArray(),
						   ".....53..".toCharArray(),
						   "8...23...".toCharArray(),
						   "7...5..4.".toCharArray(),
						   "531.7....".toCharArray()};

	
		char[][] matrix = {{'0','1'},
				          {'1','0'}};
		String s = "aSD , FE ,21 ,43#%%&";
		s.toLowerCase();
		

/*		Thread t1 = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("t1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					Thread.sleep(100);
					System.out.println("t2");
					Thread.sleep(1000);
					System.out.println("t2");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		*/
		
		System.out.println(obj.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
	}
	
}

