package edu.nyu.liangfang.leetcode;

public class countAndSay {
	public String countAndSay(int n) {
		int count = 1;
        String str = "1";
        
        while (count < n) {
            int num = 0;
            char prev = '\0';
            StringBuilder newStr = new StringBuilder();		// when multiple concatenation of string,
            for (int i = 0; i < str.length(); i++) {		// remember to use StringBuilder
                if (i == 0) {
                    num = 1;
                    prev = str.charAt(i);
                } else if (str.charAt(i) == prev) {
                    num++;
                } else if (str.charAt(i) != prev) {
                    newStr.append(String.valueOf(num)).append(prev);
                    num = 1;
                    prev = str.charAt(i);
                }
            }
            newStr.append(String.valueOf(num)).append(prev);
            str = newStr.toString();
            
            count++;
        }
        return str;    
    }
}
