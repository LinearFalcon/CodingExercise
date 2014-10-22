package edu.nyu.liangfang.leetcode.main;

import java.util.Date;

import edu.nyu.liangfang.leetcode.palindromePartitioning2;


// Main class - Entrance
public class MainFunction {	
	public static void main(String[] args) {
		
		palindromePartitioning2 obj = new palindromePartitioning2();
		
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
		long a = new Date().getTime();
		long b = new Date().getTime();
		int ss = 1; 
		int[] pre = {1,2,3};
		int[] in = {2,3,1};
		System.out.println(obj.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
}

