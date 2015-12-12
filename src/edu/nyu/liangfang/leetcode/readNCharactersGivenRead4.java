package edu.nyu.liangfang.leetcode;

public class readNCharactersGivenRead4 {
	
	public int read(char[] buf, int n) {
		int count = 0;
        boolean eof = false;
        char[] buffer = new char[4];
        while (!eof && count < n) {				// read at most n characters when eof is false
            int readNum = read4(buffer);
            if (readNum < 4) eof = true;		// break since there is no more chars left, chars number of file is less than n
            
            int len = Math.min(readNum, n - count); 	// Important!!! In case of less than 4 chars left; Do not write in for loop cause count++
            for (int i = 0; i < len; i++) {
                buf[count++] = buffer[i];
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
