package edu.nyu.liangfang.leetcode;

public class integerToRoman {
	public String intToRoman(int num) {
        char[] table = {'I', 'V', 'X', 'L', 'C', 'D' ,'M'};
        
        StringBuilder sb = new StringBuilder();
        int scale = 1000;
        for (int i = 6; i >= 0; i -= 2) {
            int digitNum = num / scale;
            if (digitNum != 0) {
                if (digitNum < 4) {
                    for (int j = 0; j < digitNum; j++) {
                        sb.append(table[i]);
                    }
                } else if (digitNum == 4) {
                    sb.append(table[i]);
                    sb.append(table[i + 1]);
                } else if (digitNum == 9) {
                    sb.append(table[i]);
                    sb.append(table[i + 2]);
                } else {
                    sb.append(table[i + 1]);
                    digitNum -= 5;
                    for (int j = 0; j < digitNum; j++) {
                        sb.append(table[i]);
                    }
                }
                num = num % scale;		// MUST!!!
            }
            scale = scale / 10;
        }
        return sb.toString();
    }
}
