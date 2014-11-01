package edu.nyu.liangfang.leetcode.main;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import edu.nyu.liangfang.leetcode.amazonCoding;
import edu.nyu.liangfang.leetcode.primeNumberGenerator;


// Main class - Entrance
public class MainFunction {	
	public static void main(String[] args) {
		
		amazonCoding obj = new amazonCoding();
		
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
		

		long a = new Date().getTime();
		long b = new Date().getTime();
		int ss = 1; 
		int[] pre = {1,2,3};
		int[] in = {1,1,0,0,1,-1,-1,1};
		
		Queue<String> Q = new LinkedList<String>();
        Q.add(null);
        
        byte bb = 0;
        
        String s1 = "abc";
        String s2 = "cba";
        System.out.println(obj.isRotation(s1, s2));
        
	}
	
}

