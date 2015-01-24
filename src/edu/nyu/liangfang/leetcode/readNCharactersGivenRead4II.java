package edu.nyu.liangfang.leetcode;

public class readNCharactersGivenRead4II {
	// read() would be called multiple times
	
	private char[] buffer = new char[4];
    private int offset = 0;		// offset of buffer: [0, 3]
    private int bufRemain = 0;  // number of chars remains in the buffer waiting to read
    
    public int read(char[] buf, int n) {
        int count = 0;
        boolean eof = false;	
        
        while (!eof && count < n) {
            int readNum = (bufRemain > 0) ? bufRemain : read4(buffer);	// read from file or buffer if there are remaining in buffer
            if (bufRemain == 0 && readNum < 4) {	// only exit condition
                eof = true;
            }
            
            int len = Math.min(n - count, readNum);	// how many characters to read this time
            for (int i = 0; i < len; i++) {     // copy from buffer to destination buf
                buf[count] = buffer[offset + i];
                count++;
            }
            
            offset = (offset + len) % 4;		// reset offset and bufRemain, it's "offset + len", not "offset + readNum"!!
            bufRemain = readNum - len;
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
