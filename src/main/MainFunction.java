package edu.nyu.liangfang.leetcode.main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import edu.nyu.liangfang.leetcode.validNumber;


// Main class - Entrance
public class MainFunction {	
	public static void main(String[] args) {
		
		validNumber obj = new validNumber();
		
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

		Writer writer = null; 
	    try {
	      writer = new BufferedWriter(new OutputStreamWriter(
	          new FileOutputStream("test.txt"), "utf-8"));
	      writer.write("sss");
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    } finally {
	      // Close the file writer
	      try {
	        writer.close();
	      } catch (Exception ex) {
	        ex.printStackTrace();
	      }
	    }
	}
	
}

