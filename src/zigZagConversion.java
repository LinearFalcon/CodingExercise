package edu.nyu.liangfang.leetcode;

public class zigZagConversion {
	// O(n) solution
	public String convert(String s, int nRows) {
        if (s.length() == 0)
            return "";
        else if (nRows == 1)
        	return s;
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nRows; i++) {
                // insert first char, break when given nRows is bigger than s.length()
                if (i < s.length()) 
                    sb.append(s.charAt(i));
                else
                    break;
                                
                int col = 1;	// treat diagonal and next vertical char as a group, each loop process a group
                while (true) {
                    // insert diagonal char
                    int index = col * (2 * nRows - 2) - i;
                    if (index >= s.length()) {
                        break;
                    }
                    
                    if (index < s.length() && index != (col-1) * (2 * nRows - 2) + i && index != col * (2 * nRows - 2) + i) {
                        sb.append(s.charAt(index));
                    }
                    
                    // insert vertical char
                    index = col * (2 * nRows - 2) + i;
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                    }
                    
                    col++;
                }
            }
            return sb.toString();
        }
    }
	
	
	// TLE solution
	public String convert_TLE(String s, int nRows) {
        if (s.length() == 0)
            return "";
//        else if (nRows == 1)
//        	return s;
        
//        char[][] zigzag = new char[nRows][(s.length() / (2 * nRows - 2) + 1) * (nRows - 1)];
        char[][] zigzag = new char[nRows][s.length()];
        
        int col = 0;
        int row = 0;
        int index = 0;
        while (index < s.length()) {
            
            boolean end = false;
            // fill vertically
//            System.out.println("row: " + row + " col: " + col + " new loop start");
            while (row < nRows) {
                zigzag[row][col] = s.charAt(index);
                System.out.println("row: " + row + " col: " + col + " " + zigzag[row][col]);
                row++;
                index++;
                if (index >= s.length()) {
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
            
            row = nRows > 2 ? row - 2 : row - 1;
            col++;
            // fill horizontally
            int count = 0;
            while (count < nRows - 2) {
                zigzag[row][col] = s.charAt(index);
//                System.out.println("row: " + row + " col: " + col + " " + zigzag[row][col]);
                row--;
                col++;
                index++;
                count++;
                if (index >= s.length()) {
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zigzag.length; i++) {
            for (int j = 0; j < zigzag[0].length; j++) {
//            	System.out.println("i: " + i + " j: " + j + " " + zigzag[i][j]);
            	
                if (zigzag[i][j] != '\0') {
                    sb.append(zigzag[i][j]);
                }
            }
        }
                
        return sb.toString();
    }
}
