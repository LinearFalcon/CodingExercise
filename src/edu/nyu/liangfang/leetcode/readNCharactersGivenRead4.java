package edu.nyu.liangfang.leetcode;

public class readNCharactersGivenRead4 {
	
	public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int count = 0;
        while (count < n) {			// read at most n characters
            int readNum = read4(buffer);
            int time = Math.min(readNum, n - count);	// Important!!! In case of less than 4 chars left; Do not write in for loop cause count++
            for (int i = 0; i < time; i++) {
                buf[count] = buffer[i];
                count++;
            }
            
            if (readNum < 4) {	// break since there is no more chars left, chars number of file is less than n
                break;
            } 
        }
        return count;
    }

	
	
	
	// pseudo method
	private int read4(char[] buffer) {
		/*
		The API: int read4(char *buf) reads 4 characters at a time from a file.
		The return value is the actual number of characters read. For example, 
		it returns 3 if there is only 3 characters left in the file.
		 */
		return 0;
	}
}
